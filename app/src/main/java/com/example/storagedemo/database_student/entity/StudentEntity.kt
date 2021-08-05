package com.example.storagedemo.database_student.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_tbl")
class StudentEntity(
    @PrimaryKey
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "address") val address: String
) {
    override fun toString(): String {
        return "$name : $address"
    }
}
