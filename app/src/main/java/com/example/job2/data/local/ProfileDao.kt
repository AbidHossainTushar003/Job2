package com.example.job2.data.local


import androidx.room.*
import com.example.job2.data.model.UserProfile
import kotlinx.coroutines.flow.Flow


/**
 * Data Access Object (DAO) for the [UserProfile] table.
 * Contains methods for interacting with the database.
 */
@Dao
interface ProfileDao {

    /**
     * Inserts a new profile into the database.
     * If the profile already exists, it will be replaced.
     *
     * @param profile The user profile to insert.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profile: UserProfile)


    /**
     * Updates an existing profile in the database.
     *
     * @param profile The user profile to update.
     */
    @Update
    suspend fun updateProfile(profile: UserProfile)


    /**
     * Deletes a profile from the database.
     *
     * @param profile The user profile to delete.
     */
    @Delete
    suspend fun deleteProfile(profile: UserProfile)


    /**
     * Retrieves all profiles from the database, ordered by ID in descending order.
     *
     * @return A [Flow] emitting the list of all user profiles.
     */
    @Query(
        "SELECT * FROM profile_table ORDER BY id DESC",
    )
    fun getAllProfiles():
            Flow<List<UserProfile>>


    /**
     * Searches for profiles whose name or email contains the given search string.
     *
     * @param search The search query.
     * @return A [Flow] emitting the list of matching user profiles.
     */
    @Query(
        """
        SELECT * FROM profile_table
        WHERE name LIKE '%' || :search || '%'
        OR email LIKE '%' || :search || '%'
        """,
    )
    fun searchProfile(
        search:String,
    ):
            Flow<List<UserProfile>>

}
