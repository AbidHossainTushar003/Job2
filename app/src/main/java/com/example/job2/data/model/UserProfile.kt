package com.example.job2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


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