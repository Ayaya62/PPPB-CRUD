package com.example.pppb_crud.data

import android.content.Context
import android.provider.CalendarContract.Instances
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pppb_crud.data.dao.UserDao
import com.example.pppb_crud.data.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppData : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppData? = null

        fun getInstance(context: Context): AppData{
            if (instance == null){
                instance = Room.databaseBuilder(context, AppData::class.java, "app-data")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }

            return instance!!
        }
    }


}