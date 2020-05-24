package com.jjp.petsitter.animals.ui.adapter

import android.view.View
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.adapter_item_animal.view.*

class AnimalsViewHolder
constructor(
    override val containerView: View,
    private val onItemClicked: ((Int) -> Unit)
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        itemView.setOnClickListener {
            onItemClicked(adapterPosition)
        }
    }

    fun setIcon(@DrawableRes icon: Int) {
        itemView.animalIcon.setImageResource(icon)
    }

    fun setBreed(breed: String) {
        itemView.animalBreed.text = breed
    }

    fun setAddress(address: String) {
        itemView.animalAddress.text = address
    }
}
