package com.ramgdeveloper.rickandmortyapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramgdeveloper.rickandmortyapi.databinding.RecyclerRowBinding
import com.ramgdeveloper.rickandmortyapi.model.RickMortyData

class RecyclerAdapter: ListAdapter<RickMortyData, RecyclerAdapter.MyViewHolder>(DiffUtilCallback) {

    object DiffUtilCallback: DiffUtil.ItemCallback<RickMortyData>(){
        override fun areItemsTheSame(oldItem: RickMortyData, newItem: RickMortyData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: RickMortyData, newItem: RickMortyData): Boolean {
            return oldItem.id == newItem.id
        }

    }

    inner class MyViewHolder(private val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root){

        fun  bind(ricky: RickMortyData?){

           /* Glide.with(binding.image)
                .load(ricky?.image)
                .error(R.drawable.ic_launcher_background)
                .into(binding.image)*/

            binding.textViewName.text = ricky?.name
            /*binding.textViewStatus.text = ricky?.status
            binding.textViewSpecies.text = ricky?.species*/
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val rickMorty = getItem(position)
        holder.bind(rickMorty)
    }
}
