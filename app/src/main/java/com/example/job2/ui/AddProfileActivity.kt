package com.example.job2.ui



import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

import com.example.job2.data.local.ProfileDatabase
import com.example.job2.data.model.UserProfile
import com.example.job2.data.repository.ProfileRepository
import com.example.job2.databinding.ActivityAddProfileBinding
import com.example.job2.viewmodel.ProfileViewModel
import com.example.job2.viewmodel.ProfileViewModelFactory



class AddProfileActivity : AppCompatActivity() {



    private lateinit var binding:
            ActivityAddProfileBinding



    private lateinit var viewModel:
            ProfileViewModel



    private var editProfile:
            UserProfile? = null





    override fun onCreate(
        savedInstanceState: Bundle?
    ) {


        super.onCreate(savedInstanceState)



        binding =
            ActivityAddProfileBinding.inflate(
                layoutInflater
            )


        setContentView(binding.root)





        val dao =
            ProfileDatabase
                .getDatabase(this)
                .profileDao()



        viewModel =
            ViewModelProvider(
                this,
                ProfileViewModelFactory(
                    ProfileRepository(dao)
                )
            )[ProfileViewModel::class.java]






        editProfile =
            intent.getSerializableExtra(
                "profile"
            ) as? UserProfile





        editProfile?.let {



            binding.etName.setText(it.name)

            binding.etEmail.setText(it.email)

            binding.etDob.setText(it.dob)

            binding.etDistrict.setText(it.district)

            binding.etMobile.setText(it.mobile)


            binding.btnSave.text =
                "Update Profile"


        }






        binding.btnSave.setOnClickListener {


            val profile =
                UserProfile(

                    id =
                        editProfile?.id ?: 0,


                    name =
                        binding.etName.text.toString(),


                    email =
                        binding.etEmail.text.toString(),


                    dob =
                        binding.etDob.text.toString(),


                    district =
                        binding.etDistrict.text.toString(),


                    mobile =
                        binding.etMobile.text.toString()

                )





            if(editProfile == null){


                viewModel.insert(profile)


                Toast.makeText(
                    this,
                    "Profile Saved",
                    Toast.LENGTH_SHORT
                ).show()


            }
            else{


                viewModel.update(profile)


                Toast.makeText(
                    this,
                    "Profile Updated",
                    Toast.LENGTH_SHORT
                ).show()


            }



            finish()


        }


    }


}