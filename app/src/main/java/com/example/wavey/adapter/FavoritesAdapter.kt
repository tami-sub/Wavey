package com.example.wavey.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.wavey.R
import com.example.wavey.data.Track
import com.example.wavey.databinding.TrackItemBinding
import com.example.wavey.ui.favorites.FavoritesFragment
import com.example.wavey.ui.favorites.FavoritesSavedFragment
import com.example.wavey.ui.favorites.FavoritesViewModel

class FavoritesAdapter(
    private val favoritesFragment: FavoritesFragment,
    private val parentFragmentManager: FragmentManager,
    activity: FragmentActivity?
)
    :RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {

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
            imageView.setImageBitmap(currentItem.image)
        }

        favoritesViewModel = ViewModelProvider(favoritesFragment).get(FavoritesViewModel::class.java)

        binding.root.setOnLongClickListener {
            favoritesViewModel.deleteTrack(currentItem)
            return@setOnLongClickListener true
        }

        binding.root.setOnClickListener(View.OnClickListener {
            this.
            parentFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.nav_host_fragment_activity_main, FavoritesSavedFragment.newInstance())
                .commit()

            val resultBundle = Bundle()
            resultBundle.putString("position", position.toString())
            parentFragmentManager.setFragmentResult("savedDetails", resultBundle)
        }
        )
    }

    fun setData(track: List<Track>){
        this.trackList = track
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return trackList.size
    }


}