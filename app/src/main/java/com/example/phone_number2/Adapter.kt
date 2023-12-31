package com.example.phone_number2

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phone_number2.databinding.FavoriteRecyclerviewBinding
import com.example.phone_number2.databinding.NonFavoriteRecyclerviewBinding

class Adapter(items : MutableList<MyItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items= mutableListOf<MyItem>()
    init{
        this.items=items
        items.sortWith(compareByDescending { it.viewType })
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType==FavoriteViewType.TRUE){
            val binding=FavoriteRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            FavoriteViewHolder(binding)
        }else {
            val binding=NonFavoriteRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            NonViewHolder(binding)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(items[position].viewType){
            (holder as FavoriteViewHolder).name.text=items[position].name
            holder.tel.text=items[position].tel
            holder.img.setImageResource(items[position].img)
            holder.favorite.text="favorite"
        }else {
            (holder as NonViewHolder).name.text=items[position].name
            holder.tel.text=items[position].tel
            holder.img.setImageResource(items[position].img)
            holder.favorite.text="non-favorite"
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position].viewType) {
            true -> 1
            false -> 0
        }
    }

    inner class FavoriteViewHolder(private val binding : FavoriteRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root){
        val name=binding.Name
        val tel=binding.tel
        val img=binding.imageView
        val favorite=binding.favorite
    }

    inner class NonViewHolder(private val binding : NonFavoriteRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root){
        val name=binding.nonName
        val tel=binding.nonTel
        val img=binding.nonImageView
        val favorite=binding.nonFavorite
    }
}