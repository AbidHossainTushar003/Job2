package com.example.job2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.job2.ui.WelcomeActivity

/**
 * The main entry point of the application.
 * This activity acts as a splash screen or a redirector that immediately
 * launches [WelcomeActivity] and finishes itself.
 */
class MainActivity : AppCompatActivity() {
    /**
     * Called when the activity is starting.
     * Starts [WelcomeActivity] and finishes the current activity.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
     * recently supplied in [onSaveInstanceState].
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, WelcomeActivity::class.java))
        finish()
    }
}
