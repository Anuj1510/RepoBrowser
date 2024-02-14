package com.example.repo_browser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.repo_browser.R
import com.example.repo_browser.models.IssuesData
import com.google.android.material.imageview.ShapeableImageView

class IssuesAdapter(private val issuesList:ArrayList<IssuesData>):RecyclerView.Adapter<IssuesAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.issue_item,
            parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return issuesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = issuesList[position]
        holder.authorImage.setImageResource(currentItem.authorImage)
        holder.issueText.text = currentItem.issue
        holder.authorName.text = currentItem.name
    }

    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        val authorImage:ShapeableImageView = itemView.findViewById(R.id.author_image)
        val issueText:TextView = itemView.findViewById(R.id.issueText)
        val authorName:TextView = itemView.findViewById(R.id.author_Name)
    }

}