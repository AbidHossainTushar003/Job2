package com.example.job2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data class representing a User Profile entity in the database.
 *
 * @property id The unique identifier for the profile (auto-generated).
 * @property name The name of the user.
 * @property email The email address of the user.
 * @property dob The date of birth of the user.
 * @property district The district where the user resides.
 * @property mobile The mobile number of the user.
 */
@Entity(tableName = "profile_table")
data class UserProfile(

    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,

    val name:String,

    val email:String,

    val dob:String,

    val district:String,

    val mobile:String,

): java.io.Serializable
