package com.codility.zipunzip

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.codility.zipunzip.utils.FileHelper
import com.codility.zipunzip.utils.Utility

class MainActivity : AppCompatActivity() {
    private val SDPath = Environment.getExternalStorageDirectory().absolutePath
    private val dataPath = "$SDPath/AndroidCodility/zipunzipFile/data/"
    private val zipPath = "$SDPath/AndroidCodility/zipunzipFile/zip/"
    private val unzipPath = "$SDPath/AndroidCodility/zipunzipFile/unzip/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Check for permission
        Utility().checkPermission(this)

        //Create dummy files
        FileHelper.saveToFile(dataPath, "This is AndroidCodility sample data 01", "dummy1.txt")
        FileHelper.saveToFile(dataPath, "This is AndroidCodility sample data 02", "dummy2.txt")
    }

    fun zipView(view: View) {
        if (FileHelper.zip(dataPath, zipPath, "dummy.zip", true)) {
            Toast.makeText(applicationContext, "Zip successfully.", Toast.LENGTH_LONG).show()
        }
    }

    fun unZipView(view: View) {
        if (FileHelper.unzip(zipPath + "dummy.zip", unzipPath)) {
            Toast.makeText(applicationContext, "Unzip successfully.", Toast.LENGTH_LONG).show()
        }
    }
}