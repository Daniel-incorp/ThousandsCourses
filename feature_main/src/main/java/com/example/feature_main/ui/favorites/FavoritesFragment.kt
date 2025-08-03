package com.example.feature_main.ui.favorites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feature_main.R
import com.example.feature_main.ui.home.adapter.CoursesAdapter
import com.example.feature_main.viewmodel.FavoritesViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private val viewModel: FavoritesViewModel by viewModel()
    private lateinit var adapter: CoursesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = CoursesAdapter {}
        val rv = view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.rvFavorites)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.favorites.collect { adapter.submitList(it) }
        }
    }
}

