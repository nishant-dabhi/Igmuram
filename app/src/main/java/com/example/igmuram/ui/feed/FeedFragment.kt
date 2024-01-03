package com.example.igmuram.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import coil.Coil
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.ViewSizeResolver
import com.example.igmuram.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private val viewModel: FeedViewModel by viewModels()
    // used viewModels() instead of activityViewModels() becouse a separate viewmodel for each instance of fragment would be created
    // in that case layout shift problem would not happen , not sharing viewmodel across top and hot
    private val feedAdapter = FeedRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val feed = arguments?.getString("feed") // TODO: turn into enum
        feed?.let { viewModel.updateFeed(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFeedBinding.inflate(inflater, container, false)
        binding.feedRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.feedRecyclerView.adapter = feedAdapter


        viewModel.feed.observe(viewLifecycleOwner) {
//            Toast.makeText(requireContext(),"Downloaded ${it.size} images",Toast.LENGTH_SHORT).show()
            it.forEach{image -> //for preloading using Coil
                val request = ImageRequest.Builder(requireContext())
                    .data("https://i.imgur.com/${image.cover}.jpg")
                    .size(binding.feedRecyclerView.width)
                    .build()
                Coil.imageLoader(requireContext()).enqueue(request)
            }
            feedAdapter.submitList(it)
        }

        return binding.root
    }


}
