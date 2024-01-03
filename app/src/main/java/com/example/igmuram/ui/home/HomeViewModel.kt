package com.example.igmuram.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.igmuram.data.ImgurRepository
import com.example.libimgur.models.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repo = ImgurRepository()
    private val _tags = MutableLiveData<List<Tag>>() // exposing non Mutable live data
    //anybody who's accessing viewmodel from outside viewmodel, they cant change that data thats why changed to "LiveData"

    val tags : LiveData<List<Tag>> = _tags

    fun fetchTags() = viewModelScope.launch (Dispatchers.IO) {
        _tags.postValue(repo.getTags())
    }
}