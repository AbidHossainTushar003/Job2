package com.example.job2.data.repository


import com.example.job2.data.local.ProfileDao
import com.example.job2.data.model.UserProfile
import kotlinx.coroutines.flow.Flow


/**
 * Repository class that abstracts access to the data sources.
 * It provides a clean API for data access to the rest of the application.
 *
 * @property dao The [ProfileDao] used to interact with the database.
 */
class ProfileRepository(

    private val dao: ProfileDao,

){


    /**
     * A [Flow] of all profiles from the database.
     */
    val allProfiles:
            Flow<List<UserProfile>> =
        dao.getAllProfiles()


    /**
     * Inserts a new profile.
     *
     * @param profile The user profile to insert.
     */
    suspend fun insert(
        profile: UserProfile
    ){

        dao.insertProfile(profile)

    }


    /**
     * Updates an existing profile.
     *
     * @param profile The user profile to update.
     */
    suspend fun update(
        profile: UserProfile
    ){

        dao.updateProfile(profile)

    }



    /**
     * Deletes a profile.
     *
     * @param profile The user profile to delete.
     */
    suspend fun delete(
        profile: UserProfile
    ){

        dao.deleteProfile(profile)

    }



    /**
     * Searches for profiles based on a query string.
     *
     * @param query The search query.
     * @return A [Flow] emitting matching user profiles.
     */
    fun search(
        query:String
    ):Flow<List<UserProfile>>{

        return dao.searchProfile(query)

    }



}
