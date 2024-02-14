package com.example.repo_browser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.repo_browser.R
import com.example.repo_browser.adapter.FragmentAdapter
import com.example.repo_browser.databinding.FragmentRepoBinding


class RepoFragment : Fragment() {
    private lateinit var binding: FragmentRepoBinding

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