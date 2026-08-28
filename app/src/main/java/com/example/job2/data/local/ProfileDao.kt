package com.example.job2.data.local


import androidx.room.*
import com.example.job2.data.model.UserProfile
import kotlinx.coroutines.flow.Flow



@Dao
interface ProfileDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profile: UserProfile)



    @Update
    suspend fun updateProfile(profile: UserProfile)



    @Delete
    suspend fun deleteProfile(profile: UserProfile)



    @Query(
        "SELECT * FROM profile_table ORDER BY id DESC",
    )
    fun getAllProfiles():
            Flow<List<UserProfile>>



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