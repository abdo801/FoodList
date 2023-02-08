package com.example.foodlist

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodlist.databinding.FoodItemBinding




class FoodAdapter(val settings:SettSave) : ListAdapter<Foods,RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Foods>() {

            override fun areItemsTheSame(oldItem: Foods, newItem: Foods): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Foods, newItem: Foods): Boolean {
                return oldItem.name == newItem.name && oldItem.imageUrl == newItem.imageUrl
            }

        }
    }

    private lateinit var binding: FoodItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        binding = FoodItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item,position)
        }
    }

    inner class ViewHolder(private val itemBinding: FoodItemBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item:Foods,position: Int){
            itemBinding.tvName.text = item.name
            itemBinding.tvName.textSize=settings.getFontSize().toFloat()
            itemBinding.ivAvatar.setImageResource(item.imageUrl)
        }
    }
}