package models

import Factory
import exceptions.NoSpotAvailableException
import exceptions.VehicleNotParkedException
import repositories.ParkingLot

data class Vehicle(
    var type: String,
    var id: Int
) {
    fun park(): Ticket {
        if (!ParkingLot.isSpotAvailable()) {
            throw NoSpotAvailableException("No spot available to park")
        }

        val ticket = Factory.generateTicket(id)

        ParkingLot.reduceAvailableSpotsByOne()
        ParkingLot.addToParkingList(this)

        return ticket
    }

    fun unPark(ticket: Ticket): Receipt {
        if(!ParkingLot.isVehicleParked(id)) {
            throw VehicleNotParkedException("Vehicle with given ID is not parked")
        }

        val receipt = Factory.generateReceipt(ticket)

        ParkingLot.increaseAvailableSpotsByOne()
        ParkingLot.removeFromParkingList(this)

        return receipt
    }
}
