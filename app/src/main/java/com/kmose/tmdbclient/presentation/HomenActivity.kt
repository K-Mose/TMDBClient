package com.kmose.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kmose.tmdbclient.R
import com.kmose.tmdbclient.databinding.ActivityHomeBinding
import com.kmose.tmdbclient.presentation.artist.ArtistActivity
import com.kmose.tmdbclient.presentation.movie.MovieActivity
import com.kmose.tmdbclient.presentation.tv.TvShowActivity

class HomenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.apply {
            moviesButton.setOnClickListener {
                val intent = Intent(this@HomenActivity, MovieActivity::class.java)
                startActivity(intent)
            }

            tvShowButton.setOnClickListener {
                val intent = Intent(this@HomenActivity, TvShowActivity::class.java)
                startActivity(intent)
            }

            artistsButton.setOnClickListener {
                val intent = Intent(this@HomenActivity, ArtistActivity::class.java)
                startActivity(intent)
            }
        }
    }
}