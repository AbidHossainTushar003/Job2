package com.example.job2.data.local


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.job2.data.model.UserProfile


/**
 * The Room database for the application.
 * Manages the local persistence of [UserProfile] entities.
 */
@Database(
    entities = [UserProfile::class],
    version = 1,
    exportSchema = false,
)
abstract class ProfileDatabase:RoomDatabase(){

    /**
     * Provides access to the [ProfileDao].
     */
    abstract fun profileDao():ProfileDao



    companion object{


        @Volatile
        private var INSTANCE:ProfileDatabase?=null


        /**
         * Gets the singleton instance of [ProfileDatabase].
         *
         * @param context The application context.
         * @return The [ProfileDatabase] instance.
         */
        fun getDatabase(
            context:Context
        ):ProfileDatabase{


            return INSTANCE ?: synchronized(this){


                val instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        ProfileDatabase::class.java,
                        "profile_database"
                    )
                        .build()



                INSTANCE = instance

                instance

            }

        }

    }

}
