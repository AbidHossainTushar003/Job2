package com.example.job2.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.job2.data.repository.ProfileRepository


/**
 * Factory class to instantiate [ProfileViewModel] with its dependency.
 *
 * @property repository The [ProfileRepository] to be passed to the ViewModel.
 */
class ProfileViewModelFactory(

    private val repository: ProfileRepository,

): ViewModelProvider.Factory {


    /**
     * Creates a new instance of the given [modelClass].
     *
     * @param modelClass The class of the ViewModel to create.
     * @return A newly created ViewModel instance.
     * @throws IllegalArgumentException if the [modelClass] is unknown.
     */
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
    ): T {


        if(
            modelClass.isAssignableFrom(
                ProfileViewModel::class.java
            )
        ){


            @Suppress("UNCHECKED_CAST")
            return ProfileViewModel(
                repository,
            ) as T


        }


        throw IllegalArgumentException(
            "Unknown ViewModel Class",
        )

    }


}
