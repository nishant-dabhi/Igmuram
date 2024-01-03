package com.example.igmuram.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.igmuram.databinding.ListItemStoryHeadBinding
import com.example.igmuram.ui.story.StoryActivity
import com.example.libimgur.models.Tag

class StoriesRecyclerAdapter :
    ListAdapter<Tag, StoriesRecyclerAdapter.StoriesVewHolder>(StoriesDiffCallBack()) {

    class StoriesVewHolder(val binding: ListItemStoryHeadBinding) : RecyclerView.ViewHolder(binding.root)

    private class StoriesDiffCallBack : DiffUtil.ItemCallback<Tag>() {
        override fun areItemsTheSame(oldItem: Tag, newItem: Tag) = (oldItem == newItem)

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Tag, newItem: Tag) = (oldItem === newItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesVewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemStoryHeadBinding.inflate(inflater, parent, false)
        return StoriesVewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoriesVewHolder, position: Int) {
        val tag = getItem(position)
        holder.binding.storyHeadTextView.text = tag.displayName
        holder.binding.storyHeadImageView.load("https://i.imgur.com/${tag.backgroundHash}.jpg")
        holder.binding.root.apply {
            setOnClickListener {
                context.startActivity(
                    Intent(context, StoryActivity::class.java).apply {
                        putExtra("tag", tag.name)
                    }
                )
            }
        }
    }
}