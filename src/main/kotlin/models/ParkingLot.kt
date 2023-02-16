package models

import Constants.SPOTS


object ParkingLot {
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
    }

    fun increaseAvailableSpotsByOne(): Int {
        if (availableSpots + 1 > SPOTS) {
            throw OverflowException("Can not increase available spots over $SPOTS")
        }
        setAvailableSpots(availableSpots + 1)
        return availableSpots
    }
}