package com.example.job2.ui



import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.job2.R
import com.example.job2.adapter.ProfileAdapter
import com.example.job2.data.local.ProfileDatabase
import com.example.job2.data.repository.ProfileRepository
import com.example.job2.databinding.ActivityProfileListBinding
import com.example.job2.viewmodel.ProfileViewModel
import com.example.job2.viewmodel.ProfileViewModelFactory

import kotlinx.coroutines.launch



class ProfileListActivity : AppCompatActivity() {



    private lateinit var binding:
            ActivityProfileListBinding


    private lateinit var viewModel:
            ProfileViewModel


    private lateinit var adapter:
            ProfileAdapter





    override fun onCreate(
        savedInstanceState: Bundle?,
    ) {

        super.onCreate(savedInstanceState)



        binding =
            ActivityProfileListBinding.inflate(
                layoutInflater
            )


        setContentView(binding.root)





        val dao =
            ProfileDatabase
                .getDatabase(this)
                .profileDao()



        val repository =
            ProfileRepository(dao)



        viewModel =
            ViewModelProvider(
                this,
                ProfileViewModelFactory(repository)
            )[ProfileViewModel::class.java]







        adapter =
            ProfileAdapter(

                onEditClick = { profile ->


                    val intent =
                        Intent(
                            this,
                            AddProfileActivity::class.java,
                        )


                    intent.putExtra(
                        "profile",
                        profile,
                    )


                    startActivity(intent)

                },



                onDeleteClick = { profile ->


                    viewModel.delete(profile)



                    Toast.makeText(
                        this,
                        getString(R.string.profile_deleted),
                        Toast.LENGTH_SHORT,
                    ).show()


                },


                onProfileClick = { profile ->


                    val intent =
                        Intent(
                            this,
                            SingleProfileActivity::class.java,
                        )


                    intent.putExtra(
                        "profile",
                        profile,
                    )


                    startActivity(intent)

                },

            )







        binding.recyclerView.apply {

            layoutManager =
                LinearLayoutManager(
                    this@ProfileListActivity
                )


            adapter =
                this@ProfileListActivity.adapter

        }







        lifecycleScope.launch {


            viewModel.allProfiles.collect { profiles ->



                adapter.submitList(profiles)



                binding.tvTotal.text =
                    getString(R.string.total_profiles, profiles.size)



            }


        }







        binding.fabAddProfile.setOnClickListener {


            startActivity(

                Intent(
                    this,
                    AddProfileActivity::class.java
                )

            )


        }



    }


}