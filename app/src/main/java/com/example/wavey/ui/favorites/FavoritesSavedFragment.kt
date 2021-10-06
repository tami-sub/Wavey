package com.example.wavey.ui.favorites

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import com.example.wavey.databinding.FavoritesSavedFragmentBinding

class FavoritesSavedFragment : Fragment() {

    companion object {
        fun newInstance() = FavoritesSavedFragment()
    }

    private lateinit var viewModel: FavoritesSavedViewModel
    private lateinit var binding:FavoritesSavedFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FavoritesSavedFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(FavoritesSavedViewModel::class.java)

        parentFragmentManager.setFragmentResultListener("savedDetails",
            this,
            { _, result ->
                val position = result.get("position").toString().toInt()

                viewModel.readAllData.observe(viewLifecycleOwner, Observer { readAllData ->
                    binding.imageView2.setImageBitmap(readAllData[position].image)
                    binding.lyrics.text = readAllData[position].text
                })
            })
        return binding.root
    }
}