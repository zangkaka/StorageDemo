package com.example.storagedemo.database_student

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.storagedemo.database_student.dao.StudentDAO
import com.example.storagedemo.database_student.entity.StudentEntity

@Database(entities = [StudentEntity::class], version = 1)
abstract class StudentRoomDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDAO

    companion object {
        private var INSTANCE: StudentRoomDatabase? = null
        private val DB_NAME = "student_db"

        fun getDatabase(context: Context): StudentRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentRoomDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}