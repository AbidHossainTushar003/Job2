package com.example.job2.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.job2.data.model.UserProfile
import com.example.job2.data.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch



class ProfileViewModel(

    private val repository: ProfileRepository,

) : ViewModel() {



    val allProfiles:
            Flow<List<UserProfile>> =
        repository.allProfiles





    fun insert(profile: UserProfile){

        viewModelScope.launch {

            repository.insert(profile)

        }

    }





    fun update(profile: UserProfile){

        viewModelScope.launch {

            repository.update(profile)

        }

    }





    fun delete(profile: UserProfile){

        viewModelScope.launch {

            repository.delete(profile)

        }

    }





    fun searchProfiles(
        query:String
    ): Flow<List<UserProfile>>{


        return repository.search(query)


    }



}