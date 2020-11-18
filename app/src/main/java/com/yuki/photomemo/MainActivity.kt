package com.yuki.photomemo

import android.app.Activity
import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val addActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddPhotoActivity::class.java)
            startActivityForResult(intent, addActivityRequestCode)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == pickPhotoRequestCode && resultCode == Activity.RESULT_OK) {
            data?.data?.let {
                if (android.os.Build.VERSION.SDK_INT >=
                    android.os.Build.VERSION_CODES.R)
                    contentResolver.takePersistableUriPermission(
                        it, Intent.FLAG_GRANT_READ_URI_PERMISSION)
                val imageView = findViewById<ImageView>(R.id.addPhotoImageView)
                imageView.setImageURI(it)
                imageUri = it
            }
        }
    }
}

