package com.example.wavey.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.wavey.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private lateinit var favoritesViewModel: FavoritesViewModel
    private var _binding: FragmentFavoritesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoritesViewModel =
            ViewModelProvider(this).get(FavoritesViewModel::class.java)

        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textFavorites
        favoritesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

//
//        val reposotory = SearchRepository(SearchLyricsApi(), "A Forest The Cure", SongRepository(
//            SongLyricsApi()))
//
//        MainScope().launch(Dispatchers.Main) {
//            val tracks = reposotory.getTrack()
//
//            for (temp in tracks.response.hits) {
//                println(temp.index)
//                println(temp.result.songArtImageUrl)
//                println(temp.result.fullTitle)
//                println(temp.result.lyricsOwnerId)
//                println(temp.result.title)
//                println(temp.result.id)
//                println(reposotory.getVideoURL(temp.result.id.toString()))
//                println(temp.result.url)
//
//            }
//        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}