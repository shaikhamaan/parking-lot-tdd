package repositories

import Constants.SPOTS
import exceptions.OverflowException
import exceptions.UnderflowException
import models.Vehicle


object ParkingLot {
    private val parkingList: MutableMap<Int, Vehicle> = mutableMapOf()
    private var availableSpots: Int = SPOTS

    fun getAvailableSpots(): Int {
        return availableSpots
    }

    fun reduceAvailableSpotsByOne(): Int {
        if (availableSpots - 1 < 0) {
            throw UnderflowException("Can not reduce spots below zero")
        }
        setAvailableSpots(availableSpots - 1)
        return availableSpots
    }

    private fun setAvailableSpots(spots: Int) {
        availableSpots = spots
    }

    fun reset() {
        availableSpots = SPOTS
        parkingList.clear()
    }

    fun increaseAvailableSpotsByOne(): Int {
        if (availableSpots + 1 > SPOTS) {
            throw OverflowException("Can not increase available spots over $SPOTS")
        }
        setAvailableSpots(availableSpots + 1)
        return availableSpots
    }

    fun addToParkingList(vehicle: Vehicle) {
        parkingList[vehicle.id] = vehicle
    }

    fun isSpotAvailable(): Boolean {
        return getAvailableSpots() == 0
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