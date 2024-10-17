package com.example.busschedule

import android.app.Application
import com.example.busschedule.appdata.AppDatabase

class BusScheduleApplication: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}