package com.kmose.tmdbclient.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kmose.tmdbclient.R
import com.kmose.tmdbclient.databinding.ActivityTvShowBinding
import com.kmose.tmdbclient.model.tvshow.TvShow
import com.kmose.tmdbclient.presentation.di.Injector
import javax.inject.Inject


class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel = ViewModelProvider(this, factory)
            .get(TvShowViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.apply {
            adapter = TvShowAdapter()
            tvShowRecyclerView.also {
                it.layoutManager = LinearLayoutManager(this@TvShowActivity)
                it.adapter = adapter
            }
        }
        displayPopularTvShow()
    }

    private fun displayPopularTvShow() {
        binding.apply {
            tvShowProgressbar.visibility = View.VISIBLE
            val responseLiveData = tvShowViewModel.getTvShows()
            responseLiveData.observe(this@TvShowActivity, Observer {
                if (it != null) {
                    adapter.setList(it)
                    adapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_LONG).show()
                }
                tvShowProgressbar.visibility = View.GONE
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
                updateTvShow()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShow() {
        binding.apply {
            tvShowProgressbar.visibility = View.VISIBLE
            val responseLiveData = tvShowViewModel.getTvShows()
            responseLiveData.observe(this@TvShowActivity, Observer {
                if (it != null ) {
                    adapter.setList(it)
                    adapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(applicationContext, "All Data are up to date", Toast.LENGTH_LONG).show()
                }
                tvShowProgressbar.visibility = View.GONE
            })
        }
    }
}