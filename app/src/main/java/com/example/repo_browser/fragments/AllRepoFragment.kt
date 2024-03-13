package com.example.repo_browser.fragments

import DescSharedViewModel
import SharedViewModel
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repo_browser.R
import com.example.repo_browser.activities.RepoActivity
import com.example.repo_browser.adapter.RepoAdapter
import com.example.repo_browser.databinding.FragmentAllRepoBinding
import com.example.repo_browser.viewmodels.RepoViewModel

class AllRepoFragment : Fragment() {
    private lateinit var binding: FragmentAllRepoBinding
    private lateinit var viewModel: RepoViewModel
    private lateinit var adapter: RepoAdapter
    private lateinit var editText: EditText
    private val sharedViewModel:SharedViewModel by activityViewModels()
    private val descSharedViewModel:DescSharedViewModel by activityViewModels()
    companion object {
        var DescString = ""
        var userString = ""
    }
//    var output:String=""

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
        adapter = RepoAdapter()
        adapter.notifyDataSetChanged()
        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(RepoViewModel::class.java)
        binding.apply {
            RecyclerViewRepo.layoutManager = LinearLayoutManager(requireContext())
            RecyclerViewRepo.setHasFixedSize(true)
            RecyclerViewRepo.adapter = adapter
            sharedViewModel.sharedText.observe(viewLifecycleOwner, Observer { newText ->
                searchRepo(newText)
            })
        }

        viewModel.searchRepo().observe(this) {
            if (it != null) {
                adapter.setList(it)
            }
        }

        adapter.onItemClick = {
            descSharedViewModel.UpdateDescText(it.name)
            val intent = Intent(requireContext(),RepoActivity::class.java)
            intent.putExtra("user",it.name)
            DescString = it.name
            userString = it.owner.login
            Toast.makeText(requireContext(),"$userString",Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

    }

    private fun searchRepo(output: String) {
        binding.apply {
            if (output.isEmpty()){
                Toast.makeText(requireContext(),"Please Enter the Repo Name",Toast.LENGTH_LONG).show()
                return
            }
            viewModel.setSearchRepo(output)
        }
    }
}