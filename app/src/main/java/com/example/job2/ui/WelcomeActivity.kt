package com.example.job2.ui


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.job2.databinding.ActivityWelcomeBinding



class WelcomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityWelcomeBinding



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        binding =
            ActivityWelcomeBinding.inflate(layoutInflater)


        setContentView(binding.root)





        binding.btnProfileList.setOnClickListener {


            startActivity(
                Intent(
                    this,
                    ProfileListActivity::class.java
                )
            )


        }


    }


}