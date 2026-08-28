package com.example.job2.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.job2.data.model.UserProfile
import com.example.job2.data.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


/**
 * ViewModel for managing and providing data for the profile-related UI.
 * Acts as a bridge between the [ProfileRepository] and the View.
 *
 * @property repository The [ProfileRepository] used to access data.
 */
class ProfileViewModel(

    private val repository: ProfileRepository,

) : ViewModel() {


    /**
     * A [Flow] of all profiles, exposed to the UI.
     */
    val allProfiles:
            Flow<List<UserProfile>> =
        repository.allProfiles




    /**
     * Launches a coroutine to insert a new profile.
     *
     * @param profile The user profile to insert.
     */
    fun insert(profile: UserProfile){

        viewModelScope.launch {

            repository.insert(profile)

        }

    }




    /**
     * Launches a coroutine to update an existing profile.
     *
     * @param profile The user profile to update.
     */
    fun update(profile: UserProfile){

        viewModelScope.launch {

            repository.update(profile)

        }

    }




    /**
     * Launches a coroutine to delete a profile.
     *
     * @param profile The user profile to delete.
     */
    fun delete(profile: UserProfile){

        viewModelScope.launch {

            repository.delete(profile)

        }

    }




    /**
     * Searches for profiles based on the provided query.
     *
     * @param query The search query.
     * @return A [Flow] emitting the list of matching user profiles.
     */
    fun searchProfiles(
        query:String
    ): Flow<List<UserProfile>>{


        return repository.search(query)


    }



}
