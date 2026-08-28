package com.example.job2.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.job2.data.repository.ProfileRepository



class ProfileViewModelFactory(

    private val repository: ProfileRepository

): ViewModelProvider.Factory {



    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {


        if(
            modelClass.isAssignableFrom(
                ProfileViewModel::class.java
            )
        ){


            return ProfileViewModel(
                repository
            ) as T


        }


        throw IllegalArgumentException(
            "Unknown ViewModel Class"
        )

    }


}