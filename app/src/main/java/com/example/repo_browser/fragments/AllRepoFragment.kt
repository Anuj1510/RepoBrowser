package com.example.repo_browser.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.repo_browser.R
import com.example.repo_browser.activities.RepoActivity
import com.example.repo_browser.adapter.RepoAdapter
import com.example.repo_browser.databinding.FragmentAllRepoBinding
import com.example.repo_browser.models.RepoData

class AllRepoFragment : Fragment() {
    private lateinit var binding: FragmentAllRepoBinding
    private lateinit var repoArrayList:ArrayList<RepoData>
    private lateinit var repoAdapter: RepoAdapter
    private lateinit var imageId:Array<Int>
    private lateinit var title:Array<String>

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
        imageId = arrayOf(
            R.drawable.candidate1,
            R.drawable.candidate2,
            R.drawable.candidate3,
            R.drawable.candidate4,
            R.drawable.candidate5,
            R.drawable.candidate6,
            R.drawable.candidate7,
            R.drawable.chrisevans
        )

        title = arrayOf(
            "Hey this is your favourite Repo....Save it",
            "Hey this is your favourite Repo....Save it",
            "Hey this is your favourite Repo....Save it",
            "Hey this is your favourite Repo....Save it",
            "Hey this is your favourite Repo....Save it",
            "Hey this is your favourite Repo....Save it",
            "Hey this is your favourite Repo....Save it",
            "Hey this is your favourite Repo....Save it"
        )

        binding.RecyclerViewRepo.layoutManager = LinearLayoutManager(this.requireContext())
        binding.RecyclerViewRepo.setHasFixedSize(true)

        repoArrayList= arrayListOf<RepoData>()
        for (i in imageId.indices){
            val data = RepoData(imageId[i],title[i])
            repoArrayList.add(data)
        }

        binding.RecyclerViewRepo.adapter = RepoAdapter(repoArrayList)

        repoAdapter = binding.RecyclerViewRepo.adapter as RepoAdapter
        repoAdapter.onItemClick = {
            val intent = Intent(this@AllRepoFragment.requireContext(),RepoActivity::class.java)
            startActivity(intent)
        }

    }
}