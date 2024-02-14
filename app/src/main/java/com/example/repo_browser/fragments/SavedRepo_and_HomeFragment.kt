package com.example.repo_browser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.repo_browser.R
import com.example.repo_browser.databinding.FragmentSavedRepoAndHomeBinding


class SavedRepo_and_HomeFragment : Fragment() {
    private lateinit var binding: FragmentSavedRepoAndHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSavedRepoAndHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.EmptyAnime.visibility = View.VISIBLE
        binding.EmptyAnime.playAnimation()

        binding.Addbutton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_savedRepo_and_HomeFragment_to_searchFragment)
        }

    }
}