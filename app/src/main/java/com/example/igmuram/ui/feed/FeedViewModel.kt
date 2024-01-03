package com.example.igmuram.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.igmuram.data.ImgurRepository
import com.example.libimgur.models.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    private val repo = ImgurRepository()
    private val _feed = MutableLiveData<List<Image>>()

    val feed: LiveData<List<Image>> = _feed // exposing non Mutable live data
    //anybody who's accessing viewmodel from outside viewmodel, they cant change that data thats why changed to "LiveData"

    fun updateFeed(feedType: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (feedType) {
                "hot" -> _feed.postValue(repo.getHotFeed())
                "top" -> _feed.postValue(repo.getTopFeed())
                else -> Log.e("FEED", "Feed has to be ether top or hot")
            }
        }
    }
}