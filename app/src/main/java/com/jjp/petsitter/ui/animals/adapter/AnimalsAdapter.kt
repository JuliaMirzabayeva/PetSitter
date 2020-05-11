package com.jjp.petsitter.ui.animals.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jjp.petsitter.R

class AnimalsAdapter
constructor(
    private val onItemClicked: ((AnimalVO) -> Unit)
): RecyclerView.Adapter<AnimalsViewHolder>() {

    private val items: MutableList<AnimalVO> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layout = inflater.inflate(R.layout.adapter_item_animal, parent, false)
        return AnimalsViewHolder(layout, this::onItemClicked)
    }

    private fun onItemClicked(position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            onItemClicked(items[position])
        }
    }

    override fun onBindViewHolder(holder: AnimalsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    private fun AnimalsViewHolder.bind(item: AnimalVO) {
        setIcon(item.icon)
        setBreed(item.breed)
        setAddress(item.address)
    }

    override fun getItemCount(): Int = items.size

    fun setItems(newItems: List<AnimalVO>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}
