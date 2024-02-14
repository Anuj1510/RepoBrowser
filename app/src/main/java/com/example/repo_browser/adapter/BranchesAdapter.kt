package com.example.repo_browser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.repo_browser.R
import com.example.repo_browser.models.BranchesData

class BranchesAdapter(private var branchesList:ArrayList<BranchesData>): RecyclerView.Adapter<BranchesAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.branches_item,
            parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return branchesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = branchesList[position]
        holder.branchesTitle.text = currentItem.branchTitle
    }

    class ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){
        val branchesTitle:TextView = itemView.findViewById(R.id.branchText)
    }

}