package utils

import Constants.HOUR_FACTOR
import java.util.Date

object Utils {
    fun getHourDifference(start: Date, end: Date): Int {
        val difference: Long = end.time - start.time
        return (difference / HOUR_FACTOR).toInt()
    }
}