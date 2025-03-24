package com.example.kotlin_configurations

import android.app.Application
import android.content.Context

class MyApplication : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        System.setProperty("kotlinx.coroutines.debug", "on" )
    }
}