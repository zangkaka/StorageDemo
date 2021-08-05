package com.example.storagedemo.database_student.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.storagedemo.database_student.entity.StudentEntity

@Dao
interface StudentDAO {
    @Query("SELECT * FROM student_tbl ORDER BY name ASC")
    suspend fun getAllStudent(): MutableList<StudentEntity>

    @Query("SELECT * FROM student_tbl WHERE name LIKE :name")
    suspend fun findNoteByTitle(name: String): StudentEntity

    @Insert
    suspend fun insert(studentEntity: StudentEntity)

    @Delete
    suspend fun delete(studentEntity: StudentEntity)
}