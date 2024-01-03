package com.example.igmuram.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.request.ImageRequest
import coil.size.ViewSizeResolver
import com.example.igmuram.R
import com.example.igmuram.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val storiesViewModel by viewModels<HomeViewModel>()
    private val storiesAdapter = StoriesRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.storiesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = storiesAdapter
        }

        setupNav()

        storiesViewModel.fetchTags()

    }

    private fun setupNav() {
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        /*
        NOTE :- not using Action bar in this app
            -------------------- ACTION BAR CODE -----------------------
               //passing each menu ID as a set of IDs becouse each,
                //menu should be considered as top level destination
                val appBarConfiguration = AppBarConfiguration(setOf(
                    R.id.navigation_hot, R.id.navigation_top))
                setupActionBarWithNavController(navController, appBarConfiguration)
            -------------------- ACTION BAR CODE -----------------------
                */
        navView.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()
        storiesViewModel.tags.observe(this) {
            it.forEach {tag -> //for preloading using Coil
                val request = ImageRequest.Builder(this)
                    .data("https://i.imgur.com/${tag.backgroundHash}.jpg")
                    .size(resources.getDimensionPixelSize(R.dimen.story_head_image_size))
                    .build()
                Coil.imageLoader(this).enqueue(request)
            }
            storiesAdapter.submitList(it)
        }
    }
}
