package com.example.repo_browser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.repo_browser.R
import com.example.repo_browser.models.RepoData
import com.google.android.material.imageview.ShapeableImageView

class RepoAdapter(private val repoList:ArrayList<RepoData>):RecyclerView.Adapter<RepoAdapter.ViewHolder>() {

    var onItemClick : ((RepoData) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.repo_item,
        parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = repoList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.title.text = currentItem.heading

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentItem)
        }
    }

    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        val titleImage: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val title:TextView = itemView.findViewById(R.id.repoText)
    }

}