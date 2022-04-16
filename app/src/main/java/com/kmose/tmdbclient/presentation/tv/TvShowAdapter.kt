package com.kmose.tmdbclient.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kmose.tmdbclient.R
import com.kmose.tmdbclient.databinding.ListItemBinding
import com.kmose.tmdbclient.model.tvshow.TvShow

class TvShowAdapter : RecyclerView.Adapter<TvShowViewHolder>(){
    private val tvShowList = ArrayList<TvShow>()
    fun setList (tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemBinding>(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int = tvShowList.size
}
class TvShowViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(tvShow: TvShow) {
        binding.apply {
            titleTextView.text = tvShow.name
            descriptionTextView.text = tvShow.overview
            val postUrl = "https://image.tmdb.org/t/p/w500/" + tvShow.posterPath
            Glide.with(binding.imageView.context)
                .load(postUrl)
                .into(binding.imageView)
        }
    }
}