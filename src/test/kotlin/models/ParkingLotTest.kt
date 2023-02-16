package models

import Constants.SPOTS
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class ParkingLotTest {
    @AfterEach
    fun tearDown() {
        ParkingLot.reset()
    }

    @Test
    fun `it should get the number of available spots`() {
        val availableSpots = ParkingLot.getAvailableSpots()
        assertEquals(SPOTS, availableSpots)
    }

    @Test
    fun `it should reduce available spots`() {
        ParkingLot.reduceAvailableSpotsByOne()
        val availableSpots = ParkingLot.getAvailableSpots()
        assertEquals(SPOTS - 1, availableSpots)
    }

    @Test
    fun `it should increase available spots`() {
        assertThrows(OverflowException::class.java) { ParkingLot.increaseAvailableSpotsByOne() }
        ParkingLot.reduceAvailableSpotsByOne()
        ParkingLot.increaseAvailableSpotsByOne()
        val availableSpots = ParkingLot.getAvailableSpots()
        assertEquals(SPOTS, availableSpots)
    }
}