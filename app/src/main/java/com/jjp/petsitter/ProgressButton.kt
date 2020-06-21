package com.jjp.petsitter

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat

class ProgressButton
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatButton(context, attrs, defStyleAttr) {

    private val progressDrawable = ProgressDrawable(
        ContextCompat.getColor(context, R.color.colorGreyDark),
        resources.getDimensionPixelSize(R.dimen.button_progress_thickness).toFloat()
    )

    private var buttonText: String = text.toString()
    private var isLoading: Boolean = false

    init {
        progressDrawable.callback = this
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        super.setText(text, type)
        if (text != LOADING_STATE_TEXT) {
            buttonText = text.toString()
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        val progressSize = height / 2

        progressDrawable.setBounds(
            width / 2 - progressSize / 2,
            height / 2 - progressSize / 2,
            width / 2 + progressSize / 2,
            height / 2 + progressSize / 2
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (isLoading) {
            drawProgress(canvas)
        } else {
            progressDrawable.stop()
        }
    }

    private fun drawProgress(canvas: Canvas) {
        if (progressDrawable.isRunning) {
            progressDrawable.draw(canvas)
        } else {
            progressDrawable.start()
        }
    }

    override fun verifyDrawable(who: Drawable): Boolean {
        return if (who is ProgressDrawable) who.isRunning else super.verifyDrawable(who)
    }

    fun setLoadingState() {
        isLoading = true
        isClickable = false
        isFocusable = false
        text = LOADING_STATE_TEXT
        invalidate()
    }

    fun setNormalState() {
        isLoading = false
        isClickable = true
        isFocusable = true
        text = buttonText
        invalidate()
    }

    companion object {
        private const val LOADING_STATE_TEXT = ""
    }
}
