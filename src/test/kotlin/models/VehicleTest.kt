package models

import Factory
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VehicleTest {
    @AfterEach
    fun tearDown() {
        Factory.reset()
    }

    @Test
    fun `it should park a vehicle`() {
        val car = Factory.getVehicle("Car")
        val ticket: Ticket = car.park()
        val parkingList = ParkingLot.getParkingList()

        assertEquals(1, ticket.vehicleId)
        assertEquals(1, ticket.ticketId)
        assertEquals(parkingList[ticket.vehicleId], car)
    }
}