package com.ramgdeveloper.rickandmortyapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramgdeveloper.rickandmortyapi.databinding.RecyclerRowBinding

class RickMortyAdapter: ListAdapter<RickMorty.Result, RickMortyAdapter.MyViewHolder>(DiffUtilCallback){

    object DiffUtilCallback: DiffUtil.ItemCallback<RickMorty.Result>(){
        override fun areItemsTheSame(oldItem: RickMorty.Result, newItem: RickMorty.Result): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: RickMorty.Result, newItem: RickMorty.Result): Boolean {
            return oldItem.id == newItem.id
        }
    }


    inner class MyViewHolder(private val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(rickyMorty: RickMorty.Result?) {
            Glide.with(binding.image)
                .load(rickyMorty?.image)
                .circleCrop()
                .into(binding.image)

            binding.textViewName.text = ("Name: "+rickyMorty?.name)
            binding.textViewSpecies.text = ("Species: "+rickyMorty?.species)
            binding.textViewStatus.text = ("Status: "+ rickyMorty?.status)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val rickyMorty = getItem(position)
        holder.bind(rickyMorty)
    }
}