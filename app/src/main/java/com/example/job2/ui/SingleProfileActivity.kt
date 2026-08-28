package com.example.job2.ui


import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.job2.R
import com.example.job2.data.model.UserProfile
import com.example.job2.databinding.ActivitySingleProfileBinding



class SingleProfileActivity :
    AppCompatActivity(){



    private lateinit var binding:
            ActivitySingleProfileBinding





    override fun onCreate(
        savedInstanceState: Bundle?,
    ) {


        super.onCreate(savedInstanceState)



        binding =
            ActivitySingleProfileBinding.inflate(
                layoutInflater
            )


        setContentView(binding.root)





        val profile =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getSerializableExtra(
                    "profile",
                    UserProfile::class.java,
                )!!
            } else {
                @Suppress("DEPRECATION")
                intent.getSerializableExtra(
                    "profile",
                ) as UserProfile
            }






        binding.tvName.text =
            getString(R.string.display_name, profile.name)


        binding.tvEmail.text =
            getString(R.string.display_email, profile.email)


        binding.tvDob.text =
            getString(R.string.display_dob, profile.dob)


        binding.tvDistrict.text =
            getString(R.string.display_district, profile.district)


        binding.tvMobile.text =
            getString(R.string.display_mobile, profile.mobile)



    }


}