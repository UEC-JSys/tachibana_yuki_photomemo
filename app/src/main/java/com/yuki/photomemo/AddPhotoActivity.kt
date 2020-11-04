package com.yuki.photomemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddPhotoActivity : AppCompatActivity() {

    private val pickPhotoRequestCode = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_photo)
    }
    val openButton: Button = findViewById(R.id.addPhotoOpenButton)
}