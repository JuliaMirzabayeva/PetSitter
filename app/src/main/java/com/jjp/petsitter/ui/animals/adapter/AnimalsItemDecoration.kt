package com.jjp.petsitter.ui.animals.adapter

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jjp.petsitter.R

class AnimalsItemDecoration(
    context: Context
) : RecyclerView.ItemDecoration() {

    private val itemMargin = context.resources.getDimensionPixelOffset(R.dimen.margin_m)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        if (position != INCORRECT_POSITION) {
            if (position == FIRST_POSITION) {
                outRect.top = itemMargin
            }
            outRect.bottom = itemMargin
        }
    }

    companion object {
        private const val INCORRECT_POSITION = -1
        private const val FIRST_POSITION = 0
    }
}
