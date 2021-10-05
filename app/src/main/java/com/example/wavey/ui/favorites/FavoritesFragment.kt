package com.example.wavey.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavey.adapter.FavoritesAdapter
import com.example.wavey.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private lateinit var favoritesViewModel: FavoritesViewModel
    private var _binding: FragmentFavoritesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        favoritesViewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)

        val adapter = FavoritesAdapter(this)
        val recyclerView = binding.rcView
        recyclerView.adapter = adapter
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        favoritesViewModel.readAllData.observe(viewLifecycleOwner, Observer { readAllData ->
            adapter.setData(readAllData)
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}