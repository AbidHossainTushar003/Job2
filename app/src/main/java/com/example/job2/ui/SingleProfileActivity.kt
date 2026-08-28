package com.example.job2.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.job2.data.model.UserProfile
import com.example.job2.databinding.ActivitySingleProfileBinding



class SingleProfileActivity :
    AppCompatActivity(){



    private lateinit var binding:
            ActivitySingleProfileBinding





    override fun onCreate(
        savedInstanceState: Bundle?
    ) {


        super.onCreate(savedInstanceState)



        binding =
            ActivitySingleProfileBinding.inflate(
                layoutInflater
            )


        setContentView(binding.root)





        val profile =
            intent.getSerializableExtra(
                "profile"
            ) as UserProfile






        binding.tvName.text =
            profile.name


        binding.tvEmail.text =
            profile.email


        binding.tvDob.text =
            profile.dob


        binding.tvDistrict.text =
            profile.district


        binding.tvMobile.text =
            profile.mobile



    }


}