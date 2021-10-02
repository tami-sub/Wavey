package com.example.wavey.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavey.R
import com.example.wavey.databinding.TrackItemBinding
import com.squareup.picasso.Picasso

class SearchAdapter(private val search: List<Hit>) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private lateinit var binding:TrackItemBinding
    class SearchViewHolder(val recyclerViewTrackItemBinding: View): RecyclerView.ViewHolder(recyclerViewTrackItemBinding)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder
        {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.track_item, parent, false)
            return SearchViewHolder(view)
        }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val result = search[position].result
        binding = TrackItemBinding.bind(holder.recyclerViewTrackItemBinding)
        with(binding){
            TrackTitle.text = result.title
            TrackNameCreator.text = result.fullTitle
            songId.text = result.lyricsOwnerId.toString()
            Picasso.with(imageView.context).load(result.headerImageUrl).into(imageView)
        }
    }
    override fun getItemCount() = search.size

}