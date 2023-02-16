import models.Ticket
import models.Vehicle

object Factory {
    private var vehicleCount = 0
    private var ticketCount = 0

    fun getVehicle(vehicleType: String): Vehicle {
        return Vehicle(vehicleType, ++vehicleCount)
    }

    fun getTicket(vehicleId: Int): Ticket {
        return Ticket(vehicleId, ++ticketCount)
    }

    fun reset() {
        vehicleCount = 0
        ticketCount = 0
    }


}