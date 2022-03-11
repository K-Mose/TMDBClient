package com.kmose.tmdbclient.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kmose.tmdbclient.R
import com.kmose.tmdbclient.databinding.ListItemBinding
import com.kmose.tmdbclient.model.artist.Artist

class ArtistAdapter : RecyclerView.Adapter<ArtistViewHolder>() {
    private val artistList = ArrayList<Artist>()
    fun setList(artists: List<Artist>) {
        artistList.clear()
        artistList.addAll(artists)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemBinding>(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int = artistList.size
}

class ArtistViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(artist: Artist) {
        binding.apply {
            titleTextView.text = artist.name
            descriptionTextView.text = "Popularity : ${artist.popularity}"
            val posterPath = artist.profilePath
            Glide.with(imageView.context)
                .load(posterPath)
                .into(imageView)
        }
    }
}