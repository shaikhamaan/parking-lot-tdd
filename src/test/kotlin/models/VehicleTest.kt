package models

import Factory
import exceptions.NoSpotAvailableException
import exceptions.VehicleNotParkedException
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import repositories.ParkingLot

class VehicleTest {
    @AfterEach
    fun tearDown() {
        ParkingLot.reset()
        Factory.reset()
    }

    @Test
    fun `it should park a vehicle`() {
        val car = Factory.generateVehicle("Car")
        val ticket: Ticket = car.park()
        val parkingList = ParkingLot.getParkingList()

        assertEquals(1, ticket.vehicleId)
        assertEquals(1, ticket.ticketId)
        assertEquals(parkingList[ticket.vehicleId], car)
    }

    @Test
    fun `it should unpark a vehicle`() {
        val car = Factory.generateVehicle("Car")
        val ticket: Ticket = car.park()
        val receipt: Receipt = car.unPark(ticket)

        assertEquals(0, receipt.getFare())
    }

    @Test
    fun `it should throw no vehicle parked exception`() {
        val car = Factory.generateVehicle("Car")
        val ticket = Factory.generateTicket(car.id)

        assertThrows<VehicleNotParkedException> { car.unPark(ticket) }
    }

    @Test
    fun `it should throw no spot available exception`() {
        val car = Factory.generateVehicle("Car")

        for (i in 0..99) {
            ParkingLot.reduceAvailableSpotsByOne()
        }
        assertThrows<NoSpotAvailableException> { car.park() }
    }
}