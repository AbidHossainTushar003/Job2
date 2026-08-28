package com.example.job2.ui


import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.job2.R
import com.example.job2.data.model.UserProfile
import com.example.job2.databinding.ActivitySingleProfileBinding


/**
 * Activity that displays the details of a single user profile.
 */
class SingleProfileActivity :
    AppCompatActivity(){


    /**
     * View binding for the activity layout.
     */
    private lateinit var binding:
            ActivitySingleProfileBinding




    /**
     * Called when the activity is starting.
     * Retrieves the profile from the intent and populates the UI.
     *
     * @param savedInstanceState If the activity is being re-initialized.
     */
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
