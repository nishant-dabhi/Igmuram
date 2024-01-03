package com.example.igmuram.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import com.example.igmuram.R
import com.example.igmuram.databinding.ListItemGalleryImageBinding
import com.example.libimgur.models.Image

class FeedRecyclerAdapter() :
    ListAdapter<Image, FeedRecyclerAdapter.FeedViewHolder>(FeedDiffCallBack()) { //ListAdapter hase 2items (T,VH) : T is object type, VH is VewHolder type


    class FeedViewHolder(val binding: ListItemGalleryImageBinding) :
        RecyclerView.ViewHolder(binding.root)

    private class FeedDiffCallBack : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.toString() == newItem.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater: LayoutInflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemGalleryImageBinding.inflate(inflater, parent, false)
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val image = getItem(position)
        holder.binding.captionTextView.text = image.title
        holder.binding.imageView.load("https://i.imgur.com/${image.cover}.jpg") {
            placeholder(R.drawable.placeholder_image)
            error(R.drawable.placeholder_image)
        }
    }
}