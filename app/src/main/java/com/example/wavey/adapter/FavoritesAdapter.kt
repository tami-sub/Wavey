package com.example.wavey.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.wavey.R
import com.example.wavey.data.Track
import com.example.wavey.databinding.TrackItemBinding
import com.example.wavey.ui.favorites.FavoritesFragment
import com.example.wavey.ui.favorites.FavoritesViewModel

class FavoritesAdapter(private val favoritesFragment: FavoritesFragment) :RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {

    private lateinit var binding: TrackItemBinding
    private var trackList = emptyList<Track>()
    private lateinit var favoritesViewModel: FavoritesViewModel


    inner class FavoritesViewHolder(val recyclerViewTrackItemBinding: View):
        RecyclerView.ViewHolder(recyclerViewTrackItemBinding){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.track_item, parent, false)
            return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        binding = TrackItemBinding.bind(holder.recyclerViewTrackItemBinding)
        val currentItem = trackList[position]
        with(binding){
            TrackTitle.text = currentItem.title
            TrackNameCreator.text = currentItem.owner
            songId.text = currentItem.trackId.toString()
        }

        favoritesViewModel = ViewModelProvider(favoritesFragment).get(FavoritesViewModel::class.java)

        binding.root.setOnLongClickListener {
            Log.d("test2", currentItem.title)
            favoritesViewModel.deleteTrack(currentItem)
            return@setOnLongClickListener true
        }
    }

    fun setData(track: List<Track>){
        this.trackList = track
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return trackList.size
    }


}