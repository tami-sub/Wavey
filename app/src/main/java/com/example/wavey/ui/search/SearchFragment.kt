package com.example.wavey.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wavey.R
import com.example.wavey.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var track: String


    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(inflater, container, false)

        track = binding.searchField.text.toString()
        binding.searchField.addTextChangedLigitstener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                track = p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        binding.button.setOnClickListener {
            childFragmentManager.popBackStackImmediate()
            childFragmentManager.beginTransaction()
                .addToBackStack(null)
                .add(R.id.rcFragment, SearchRecyclerFragment.newInstance())
                .commit()

            val result = Bundle()
            result.putString("track", track)
            childFragmentManager.setFragmentResult("fromParent", result)
        }

        return binding.root
    }
}