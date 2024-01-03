package com.example.igmuram.ui.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.igmuram.data.ImgurRepository
import com.example.libimgur.models.Image
import com.example.libimgur.models.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoryViewModel : ViewModel() {
    private val repo = ImgurRepository()
    private val _images = MutableLiveData<List<Image>>() // exposing non Mutable live data
    //anybody who's accessing viewmodel from outside viewmodel, they cant change that data thats why changed to "LiveData"

    val images: LiveData<List<Image>> = _images

    fun fetchTagGallery(tagName: String) = viewModelScope.launch(Dispatchers.IO) {
        _images.postValue(repo.getTagGallery(tagName))
    }
}