package com.example.repo_browser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repo_browser.R
import com.example.repo_browser.adapter.IssuesAdapter
import com.example.repo_browser.databinding.FragmentIssuesBinding
import com.example.repo_browser.models.IssuesData

class IssuesFragment : Fragment() {

    private lateinit var binding: FragmentIssuesBinding
    private lateinit var issuesArray:ArrayList<IssuesData>
    private lateinit var issuesAdapter: IssuesAdapter
    private lateinit var image:Array<Int>
    private lateinit var name:Array<String>
    private lateinit var issue:Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIssuesBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image = arrayOf(
            R.drawable.candidate1,
            R.drawable.candidate2,
            R.drawable.candidate3,
            R.drawable.candidate4,
            R.drawable.candidate5,
            R.drawable.candidate6,
            R.drawable.candidate7,
            R.drawable.chrisevans
        )

        issue = arrayOf(
            "Hey I just found an Issue",
            "Hey I just found an Issue",
            "Hey I just found an Issue",
            "Hey I just found an Issue",
            "Hey I just found an Issue",
            "Hey I just found an Issue",
            "Hey I just found an Issue",
            "Hey I just found an Issue"
        )

        name = arrayOf(
            "Anuj Shahi",
            "Nand Tiwari",
            "Zamiul Ahmed Khan",
            "Gaurav Nitian",
            "Nand Ki Bhabhi",
            "Zamiul ki Biwi",
            "Gaurav ki Piku",
            "Zamiul Bhujang"
        )
        issuesArray = arrayListOf<IssuesData>()

        binding.IssuesRecyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        binding.IssuesRecyclerView.setHasFixedSize(true)

        for(i in image.indices){
            val data = IssuesData(image[i],issue[i],name[i])
            issuesArray.add(data)
        }
        binding.IssuesRecyclerView.adapter = IssuesAdapter(issuesArray)

    }
}