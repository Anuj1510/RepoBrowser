package com.example.repo_browser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repo_browser.R
import com.example.repo_browser.adapter.BranchesAdapter
import com.example.repo_browser.databinding.FragmentBranchesBinding
import com.example.repo_browser.models.BranchesData

class BranchesFragment : Fragment() {

    private lateinit var binding: FragmentBranchesBinding
    private lateinit var branchesArray: ArrayList<BranchesData>
    private lateinit var branchesAdapter: BranchesAdapter
    private lateinit var branches:Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBranchesBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        branches = arrayOf(
            "Here You will see the branch",
            "Here You will see the branch",
            "Here You will see the branch",
            "Here You will see the branch",
            "Here You will see the branch",
            "Here You will see the branch",
            "Here You will see the branch",
            "Here You will see the branch",
            "Here You will see the branch",
            "Here You will see the branch"
        )
        branchesArray = arrayListOf<BranchesData>()
        for(i in branches.indices){
            val data = BranchesData(branches[i])
            branchesArray.add(data)
        }
        binding.BranchesRecyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        binding.BranchesRecyclerView.setHasFixedSize(true)
        binding.BranchesRecyclerView.adapter = BranchesAdapter(branchesArray)
    }
}