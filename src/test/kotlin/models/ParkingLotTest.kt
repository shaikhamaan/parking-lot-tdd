package models

import Constants.AVAILABLE_SPOTS
import Factory
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import repositories.ParkingLot

class ParkingLotTest {
    @AfterEach
    fun tearDown() {
        ParkingLot.reset()
        Factory.reset()
    }

    @Test
    fun `it should check if the spot is available`() {
        val spotStatus = ParkingLot.isSpotAvailable()

        assertTrue(spotStatus)
    }

    @Test
    fun `it should reduce available spots`() {
        ParkingLot.reduceAvailableSpotsByOne()

        val availableSpots = ParkingLot.getAvailableSpots()

        assertEquals(AVAILABLE_SPOTS - 1, availableSpots)
    }

    @Test
    fun `it should increase available spots`() {
        ParkingLot.reduceAvailableSpotsByOne()
        ParkingLot.increaseAvailableSpotsByOne()

        val availableSpots = ParkingLot.getAvailableSpots()

        assertEquals(AVAILABLE_SPOTS, availableSpots)
    }
}