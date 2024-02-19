package com.example.repo_browser.fragments

import SharedViewModel
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.example.repo_browser.R
import com.example.repo_browser.api.ApiInterface
import com.example.repo_browser.api.Communicator
import com.example.repo_browser.api.RetrofitInstance
import com.example.repo_browser.databinding.FragmentSearchBinding
import com.example.repo_browser.models.RepoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchFragment : Fragment(),Communicator {
    private lateinit var binding: FragmentSearchBinding
//    private lateinit var communicator: Communicator
    private val sharedViewModel:SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.SearchImageView.playAnimation()
//        communicator = activity as Communicator
        sharedViewModel.sharedText.observe(viewLifecycleOwner) { sharedText ->
            binding.OwnerEditText.setText(sharedText)
        }
        binding.GetRepoBtn.setOnClickListener {
            sharedViewModel.updateText(binding.OwnerEditText.text.toString())
            Navigation.findNavController(view).navigate(R.id.action_searchFragment_to_allRepoFragment)

        }
    }

    override fun passData(editTextData: String) {
        val bundle = Bundle()
        bundle.putString("message",editTextData)
        val AllRepoFragment = AllRepoFragment()
        AllRepoFragment.arguments = bundle
    }
}