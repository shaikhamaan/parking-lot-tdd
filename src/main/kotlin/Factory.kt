import Constants.FARE
import models.Receipt
import models.Ticket
import models.Vehicle
import utils.Utils
import java.util.*

object Factory {
    private var vehicleCount = 0
    private var ticketCount = 0

    fun generateVehicle(vehicleType: String): Vehicle {
        return Vehicle(vehicleType, ++vehicleCount)
    }

    fun generateTicket(vehicleId: Int): Ticket {
        return Ticket(vehicleId, ++ticketCount)
    }

    fun generateReceipt(ticket: Ticket): Receipt {
        val receipt = Receipt(ticket.vehicleId, ticket.ticketId, ticket.entryTime)
        val fare = generateFare(ticket)
        receipt.setFare(fare)
        return receipt
    }

    private fun generateFare(ticket: Ticket): Int {
        return Utils.getHourDifference(ticket.entryTime, Date()) * FARE
    }

    fun reset() {
        vehicleCount = 0
        ticketCount = 0
    }
}
