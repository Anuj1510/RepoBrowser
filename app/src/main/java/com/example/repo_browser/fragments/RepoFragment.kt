package com.example.repo_browser.fragments

import DescSharedViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.repo_browser.adapter.FragmentAdapter
import com.example.repo_browser.databinding.FragmentRepoBinding
import com.example.repo_browser.models.RepoData
import com.example.repo_browser.viewmodels.DescViewModel


class RepoFragment : Fragment() {
    private lateinit var binding: FragmentRepoBinding
    private val descSharedViewModel:DescSharedViewModel by activityViewModels()
    private lateinit var viewModel:DescViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRepoBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(DescViewModel::class.java)
        val stringDesc = AllRepoFragment.DescString
        val stringUser = AllRepoFragment.userString
        viewModel.RepoDescription("$stringUser/$stringDesc")
        viewModel.getUserDesc().observe(this){
            if(it!=null){
                binding.RepoDesc.text = it[0].description
            }
        }
        descSharedViewModel.DescText.observe(viewLifecycleOwner, Observer { newText ->
            Toast.makeText(requireContext(),"hello",Toast.LENGTH_SHORT).show()
        })

        val fragmentAdapter = FragmentAdapter(childFragmentManager)
        // supportFragmentManager --> for fragment in activity
        // childFragmentManager --> for fragment in fragment
        fragmentAdapter.addFragment(BranchesFragment(),"BRANCHES")
        fragmentAdapter.addFragment(IssuesFragment(),"ISSUES")
        fragmentAdapter.addFragment(CommitFragment(),"COMMITS")

        binding.viewPager.adapter = fragmentAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)


    }


}