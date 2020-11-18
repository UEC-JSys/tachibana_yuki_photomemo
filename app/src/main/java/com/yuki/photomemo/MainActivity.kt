package com.yuki.photomemo

import android.app.Activity
import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val addActivityRequestCode = 1
    private lateinit var viewModel: PhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = PhotoListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this).get(PhotoViewModel::class.java)
        viewModel.allPhotos.observe(this, Observer { photos ->
            photos?.let { adapter.setPhotos(it) }
        })


        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddPhotoActivity::class.java)
            startActivityForResult(intent, addActivityRequestCode)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == addActivityRequestCode) {
            if(resultCode != Activity.RESULT_OK) {
                Toast.makeText(
                    applicationContext,
                    "Photo additions have been cancelled.",
                Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}

