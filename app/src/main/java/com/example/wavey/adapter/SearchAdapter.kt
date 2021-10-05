package com.example.wavey.adapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wavey.R
import com.example.wavey.databinding.TrackItemBinding
import com.example.wavey.search.Hit
import com.example.wavey.ui.search.searchedSong.SearchedSongFragment
import com.squareup.picasso.Picasso

class SearchAdapter(private val search: List<Hit>, private val parentFragmentManager: FragmentManager) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){

    private lateinit var binding:TrackItemBinding

    inner class SearchViewHolder(val recyclerViewTrackItemBinding: View):
        RecyclerView.ViewHolder(recyclerViewTrackItemBinding)


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
            songId.text = result.id.toString()
            Picasso.with(imageView.context).load(result.headerImageUrl).into(imageView)
        }

        binding.root.setOnClickListener(View.OnClickListener {
            Log.d("test", position.toString())
            parentFragmentManager.popBackStackImmediate()
            parentFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.rcFragment, SearchedSongFragment.newInstance())
                .commit()

            val resultBundle = Bundle()
            Log.d("test", result.id.toString())
            resultBundle.putString("trackId", result.id.toString())
            resultBundle.putString("name",result.title)
            resultBundle.putString("owner",result.fullTitle)
            resultBundle.putString("trackURL", result.url)

            parentFragmentManager.setFragmentResult("songDetails", resultBundle)
        })
    }
    override fun getItemCount() = search.size
}