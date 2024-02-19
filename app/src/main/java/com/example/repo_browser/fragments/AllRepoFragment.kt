package com.example.repo_browser.fragments

import SharedViewModel
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.repo_browser.R
import com.example.repo_browser.activities.RepoActivity
import com.example.repo_browser.adapter.RepoAdapter
import com.example.repo_browser.databinding.FragmentAllRepoBinding
import com.example.repo_browser.models.RepoData
import com.example.repo_browser.viewmodels.RepoViewModel

class AllRepoFragment : Fragment() {
    private lateinit var binding: FragmentAllRepoBinding
    private lateinit var viewModel: RepoViewModel
    private lateinit var adapter: RepoAdapter
    private lateinit var editText: EditText
    private val sharedViewModel:SharedViewModel by activityViewModels()
    private var output:String="WeVoteAdmin"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllRepoBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        editText = requireView().findViewById(R.id.OwnerEditText)
//        output = arguments?.getString("message")
        sharedViewModel.sharedText.observe(viewLifecycleOwner, Observer { newText ->
            output = newText
        })
        if(output.isEmpty()){
            Toast.makeText(requireContext(),"String is empty",Toast.LENGTH_SHORT).show()
        }
        adapter = RepoAdapter()
        adapter.notifyDataSetChanged()
        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(RepoViewModel::class.java)
        binding.apply {
            RecyclerViewRepo.layoutManager = LinearLayoutManager(requireContext())
            RecyclerViewRepo.setHasFixedSize(true)
            RecyclerViewRepo.adapter = adapter
            searchRepo()
//            editText.setOnKeyListener { v, keyCode, event ->
//                if(event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
//
//                    return@setOnKeyListener true
//                }
//                return@setOnKeyListener false
//            }
        }

        viewModel.searchRepo().observe(this) {
            if (it != null) {
                adapter.setList(it)
            }
        }

    }

    private fun searchRepo() {
        binding.apply {
            val query = output
            if(query.isEmpty()) return
            viewModel.setSearchRepo(query)
        }
    }
}