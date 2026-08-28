package com.example.job2.ui


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.job2.databinding.ActivityWelcomeBinding


/**
 * The initial activity shown to the user.
 * Provides a welcome screen with a button to navigate to the profile list.
 */
class WelcomeActivity : AppCompatActivity() {

    /**
     * View binding for the activity layout.
     */
    private lateinit var binding: ActivityWelcomeBinding


    /**
     * Called when the activity is starting.
     *
     * @param savedInstanceState If the activity is being re-initialized.
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        binding =
            ActivityWelcomeBinding.inflate(layoutInflater)


        setContentView(binding.root)





        binding.btnProfileList.setOnClickListener {


            startActivity(
                Intent(
                    this,
                    ProfileListActivity::class.java,
                )
            )


        }


    }


}
