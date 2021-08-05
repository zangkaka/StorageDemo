package com.example.storagedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.storagedemo.database_student.StudentRoomDatabase
import com.example.storagedemo.database_student.entity.StudentEntity
import com.example.storagedemo.internal_storage.InternalDemo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var studentRoomDatabase: StudentRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentRoomDatabase = StudentRoomDatabase.getDatabase(this)

        val studentEntity = StudentEntity("Tom", "HaNoi")
        CoroutineScope(Dispatchers.Main).launch {
//            studentRoomDatabase.studentDao().insert(studentEntity)
        }

        //Internal storage
        InternalDemo.writeFile(this)

        findViewById<View>(R.id.show_btn).setOnClickListener {
//            var list: MutableList<StudentEntity> = mutableListOf()
//            CoroutineScope(Dispatchers.Main).launch {
//                list = studentRoomDatabase.studentDao().getAllStudent()
//                Log.d("TAG", "onCreate: ${list.size} ${list[0]}")
//            }

            //Internal storage
            InternalDemo.readFile(this)

        }
    }
}