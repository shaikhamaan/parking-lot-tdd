package models

import java.util.*

class Receipt(var vehicleId: Int, var ticketId: Int, var entryTime: Date ) {
    fun setFare(fare: Int) {
        this.fare = fare
    }

    fun getFare(): Int {
        return fare
    }

    private var fare: Int = 0
    var exitTime: Date = Date()
}
