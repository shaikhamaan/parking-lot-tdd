package repositories

import Constants.AVAILABLE_SPOTS
import exceptions.OverflowException
import exceptions.UnderflowException
import models.Vehicle


object ParkingLot {
    private val parkingList: MutableMap<Int, Vehicle> = mutableMapOf()
    private var availableSpots: Int = AVAILABLE_SPOTS

    fun getAvailableSpots(): Int {
        return availableSpots
    }

    fun reduceAvailableSpotsByOne(): Int {
        if (availableSpots < 1) {
            throw UnderflowException("Can not reduce spots below zero")
        }
        setAvailableSpots(availableSpots - 1)
        return availableSpots
    }

    private fun setAvailableSpots(spots: Int) {
        availableSpots = spots
    }

    fun reset() {
        availableSpots = AVAILABLE_SPOTS
        parkingList.clear()
    }

    fun increaseAvailableSpotsByOne(): Int {
        if (availableSpots + 1 > AVAILABLE_SPOTS) {
            throw OverflowException("Only $AVAILABLE_SPOTS are available")
        }
        setAvailableSpots(availableSpots + 1)
        return availableSpots
    }

    fun addToParkingList(vehicle: Vehicle) {
        parkingList[vehicle.id] = vehicle
    }

    fun isSpotAvailable(): Boolean {
        return availableSpots != 0
    }

    fun getParkingList(): MutableMap<Int, Vehicle> {
        return parkingList
    }

    fun isVehicleParked(id: Int): Boolean {
        return parkingList.containsKey(id)
    }

    fun removeFromParkingList(vehicle: Vehicle) {
        parkingList.remove(vehicle.id)
    }
}