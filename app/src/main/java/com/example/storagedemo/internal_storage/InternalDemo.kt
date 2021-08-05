package com.example.storagedemo.internal_storage

import android.content.Context
import android.media.MediaParser
import android.util.Log
import android.widget.Toast
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class InternalDemo {


    companion object {
        private val FILE_NAME = "my_file.txt"

        fun writeFile(context: Context) {
            val fileOutputStream = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)
            val outputStreamWriter = OutputStreamWriter(fileOutputStream)
            outputStreamWriter.write("Hello world!")
            outputStreamWriter.close()
            Toast.makeText(context, "Save file successfully", Toast.LENGTH_SHORT).show()
        }

        fun readFile(context: Context) {
            val fileInputStream = context.openFileInput(FILE_NAME)
            val inputStreamReader = InputStreamReader(fileInputStream)
            val inputBuffer = charArrayOf()
            var str = ""
            val charRead = 0
            while ((charRead == inputStreamReader.read(inputBuffer))) {
                val readStr = inputBuffer.copyOf(charRead)
                str += readStr
            }
            inputStreamReader.close()
            Log.d("TAG", "readFile: $str")

        }
    }


}