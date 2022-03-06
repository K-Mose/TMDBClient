package com.kmose.tmdbclient.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kmose.tmdbclient.R
import com.kmose.tmdbclient.databinding.ActivityTvShowBinding


class TvShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
    }
}