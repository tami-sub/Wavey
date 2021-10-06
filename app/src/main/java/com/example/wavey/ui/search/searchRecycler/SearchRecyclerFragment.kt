package com.example.wavey.ui.search.searchRecycler

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
import com.example.wavey.adapter.SearchAdapter


class SearchRecyclerFragment : Fragment() {

    private lateinit var searchRecyclerViewModel: SearchRecyclerViewModel
    private lateinit var binding: FragmentSearchRecyclerBinding
    private lateinit var factory: SearchRecyclerModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchRecyclerBinding.inflate(inflater, container, false)

        parentFragmentManager.setFragmentResultListener("fromParent",
            this,
            { _, result ->
                val track = result.get("track").toString()
                startSearch(track) })

        return binding.root
    }

        private fun startSearch(track: String) {

        val repository = SearchRepository(SearchLyricsApi(), track)

        factory = SearchRecyclerModelFactory(repository)
        searchRecyclerViewModel = ViewModelProvider(this, factory).get(SearchRecyclerViewModel::class.java)
        searchRecyclerViewModel.getSearch()

        searchRecyclerViewModel.search.observe(viewLifecycleOwner, Observer { search ->
            binding.rcView.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = SearchAdapter(search, parentFragmentManager)
            }
        })
    }

    companion object {
        fun newInstance() = SearchRecyclerFragment()
    }
}