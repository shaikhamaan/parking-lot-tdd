package models

import Factory

data class Vehicle(
    var type: String,
    var id: Int
) {
    fun park(): Ticket {
        if (ParkingLot.isSpotAvailable()) {
            throw NoSpotAvailableException("No spot available to park")
        }

        val ticket = Factory.getTicket(id)

        ParkingLot.reduceAvailableSpotsByOne()
        ParkingLot.addToParkingList(this)

        return ticket
    }
}
