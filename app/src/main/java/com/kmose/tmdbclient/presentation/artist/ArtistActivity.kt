package com.kmose.tmdbclient.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kmose.tmdbclient.R
import com.kmose.tmdbclient.databinding.ActivityArtistBinding
import com.kmose.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding: ActivityArtistBinding
    private lateinit var adapter: ArtistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent()
            .inject(this)
        artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = ArtistAdapter()
        binding.apply {
            artistRecyclerView.also {
                it.adapter = adapter
                it.layoutManager = LinearLayoutManager(this@ArtistActivity)
            }
        }
        displayPopularArtist()
    }

    private fun displayPopularArtist() {
        binding.apply {
            artistProgressbar.visibility = View.VISIBLE
            val responseLiveData = artistViewModel.getArtists()
            responseLiveData.observe(this@ArtistActivity, Observer {
                if (it != null) {
                    adapter.setList(it)
                    adapter.notifyDataSetChanged()
                }
                artistProgressbar.visibility = View.GONE
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateArtist()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtist() {
        binding.apply {
            artistProgressbar.visibility = View.VISIBLE
            val responseLiveData = artistViewModel.getArtists()
            responseLiveData.observe(this@ArtistActivity, Observer {
                if (it != null) {
                    adapter.setList(it)
                    adapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(applicationContext, "All Data are up to date", Toast.LENGTH_LONG).show()
                }
                artistProgressbar.visibility = View.GONE
            })
        }
    }
}