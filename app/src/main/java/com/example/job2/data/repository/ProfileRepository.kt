package com.example.job2.data.repository


import com.example.job2.data.local.ProfileDao
import com.example.job2.data.model.UserProfile
import kotlinx.coroutines.flow.Flow



class ProfileRepository(

    private val dao: ProfileDao,

){



    val allProfiles:
            Flow<List<UserProfile>> =
        dao.getAllProfiles()



    suspend fun insert(
        profile: UserProfile
    ){

        dao.insertProfile(profile)

    }



    suspend fun update(
        profile: UserProfile
    ){

        dao.updateProfile(profile)

    }




    suspend fun delete(
        profile: UserProfile
    ){

        dao.deleteProfile(profile)

    }




    fun search(
        query:String
    ):Flow<List<UserProfile>>{

        return dao.searchProfile(query)

    }



}