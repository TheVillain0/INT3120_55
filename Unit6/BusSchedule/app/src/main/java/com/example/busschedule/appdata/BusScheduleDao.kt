package com.example.busschedule.appdata

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {
    @Query("SELECT * FROM bus_schedule ORDER BY arrivalTime")
    fun getAllSchedules(): Flow<List<BusSchedule>>

    @Query("SELECT * FROM bus_schedule WHERE stopName = :stopName")
    fun getScheduleByStopName(stopName: String): Flow<BusSchedule>
}
  }