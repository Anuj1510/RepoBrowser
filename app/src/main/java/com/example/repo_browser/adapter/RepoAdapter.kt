package com.example.repo_browser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.repo_browser.R
import com.example.repo_browser.databinding.RepoItemBinding
import com.example.repo_browser.models.RepoData
import com.google.android.material.imageview.ShapeableImageView

class RepoAdapter:RecyclerView.Adapter<RepoAdapter.ViewHolder>() {


    var onItemClick : ((RepoData) -> Unit)? = null

    private val list = ArrayList<RepoData>()

    fun setList(repo:ArrayList<RepoData>){
        list.clear()
        list.addAll(repo)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = RepoItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(list[position])
        }
    }

    inner class ViewHolder(val binding:RepoItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(repo:RepoData){
            binding.apply{
                repo.owner?.let {
                    Glide.with(itemView.context)
                        .load(it.avatar_url)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .centerCrop()
                        .into(titleImage)
                }

                repoText.text = repo.name
            }
        }
    }

}