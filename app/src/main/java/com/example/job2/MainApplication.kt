package com.example.job2

import android.app.Application

/**
 * Base class for maintaining global application state.
 * This is the entry point for the application process.
 */
class MainApplication : Application() {
    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     */
    override fun onCreate() {
        super.onCreate()
    }
}
