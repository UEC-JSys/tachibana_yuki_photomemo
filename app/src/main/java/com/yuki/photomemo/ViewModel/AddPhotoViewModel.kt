package com.yuki.photomemo.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.yuki.photomemo.Model.Photo
import com.yuki.photomemo.Model.PhotoRepository
import com.yuki.photomemo.Model.PhotoRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddPhotoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PhotoRepository
    init {
        val photoDao = PhotoRoomDatabase.getPhotoDatabase(application).photoDao()
        repository = PhotoRepository(photoDao)
    }

    fun insert(photo: Photo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(photo)
    }
}
