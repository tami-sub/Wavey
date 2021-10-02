package com.example.wavey.ui.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavey.databinding.FragmentSearchRecyclerBinding
import com.example.wavey.repository.SearchLyricsApi
import com.example.wavey.repository.SearchRepository
import com.example.wavey.repository.SongLyricsApi
import com.example.wavey.repository.SongRepository
import com.example.wavey.search.SearchAdapter


class SearchRecyclerFragment : Fragment() {

    private lateinit var searchRecyclerViewModel: SearchRecyclerViewModel
    private lateinit var binding: FragmentSearchRecyclerBinding
    private lateinit var factory: SearchRecyclerModelFactory
    private lateinit var track: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSearchRecyclerBinding.inflate(inflater, container, false)

        parentFragmentManager.setFragmentResultListener("fromParent",
            this,
            { _, result ->
                val track = result.get("track").toString()
                deepdown(track) })

        return binding.root
    }

        private fun deepdown(track: String) {

        val repository = SearchRepository(SearchLyricsApi(), track, SongRepository(SongLyricsApi()))

        factory = SearchRecyclerModelFactory(repository)
        searchRecyclerViewModel = ViewModelProvider(this, factory).get(SearchRecyclerViewModel::class.java)
        searchRecyclerViewModel.getSearch()

        searchRecyclerViewModel.search.observe(viewLifecycleOwner, Observer { search ->
            binding.rcView.also {
                it.layoutManager = LinearLayoutManager(requireContext())
//                it.setHasFixedSize(true)
                Log.d("test", search.toString())
                it.adapter = SearchAdapter(search)
            }
        })
    }
    companion object {
        fun newInstance() = SearchRecyclerFragment()
    }
}