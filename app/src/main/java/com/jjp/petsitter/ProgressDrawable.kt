package com.jjp.petsitter

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.RectF
import android.graphics.Rect
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator

class ProgressDrawable
constructor(
    progressColor: Int,
    private val progressThickness: Float
) : Drawable(), Animatable {

    private val viewBounds: RectF = RectF()
    private var modeAppearing: Boolean = false
    private var currentGlobalAngleOffset: Float = 0f

    private var isAnimationRunning: Boolean = false

    private var currentGlobalAngle: Float = 0f
        set(value) {
            field = value
            invalidateSelf()
        }

    private var currentSweepAngle: Float = 0f
        set(value) {
            field = value
            invalidateSelf()
        }

    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = progressColor
        strokeWidth = progressThickness
        style = Paint.Style.STROKE
    }

    private val angleAnimator: ObjectAnimator = ObjectAnimator.ofFloat(
        this, this::currentGlobalAngle.name, FULL_CIRCLE_DEGREE
    ).apply {
        interpolator = LinearInterpolator()
        duration = ANGLE_ANIMATOR_DURATION
        repeatMode = ValueAnimator.RESTART
        repeatCount = ValueAnimator.INFINITE
    }

    private val sweepAnimator: ObjectAnimator = ObjectAnimator.ofFloat(
        this, this::currentSweepAngle.name, FULL_CIRCLE_DEGREE - MIN_SWEEP_ANGLE * 2
    ).apply {
        interpolator = DecelerateInterpolator()
        duration = SWEEP_ANIMATOR_DURATION
        repeatMode = ValueAnimator.RESTART
        repeatCount = ValueAnimator.INFINITE
    }

    private val sweepAnimatorListener = object : AnimatorListener {
        override fun onAnimationStart(animation: Animator) = Unit

        override fun onAnimationEnd(animation: Animator) = Unit

        override fun onAnimationCancel(animation: Animator) = Unit

        override fun onAnimationRepeat(animation: Animator) {
            toggleAppearingMode()
        }
    }

    private fun toggleAppearingMode() {
        modeAppearing = !modeAppearing
        if (modeAppearing) {
            currentGlobalAngleOffset = (currentGlobalAngleOffset + MIN_SWEEP_ANGLE * 2) % FULL_CIRCLE_DEGREE
        }
    }

    override fun draw(canvas: Canvas) {
        var startAngle = currentGlobalAngle - currentGlobalAngleOffset
        var sweepAngle = currentSweepAngle
        if (modeAppearing) {
            sweepAngle += MIN_SWEEP_ANGLE
        } else {
            startAngle += sweepAngle
            sweepAngle = FULL_CIRCLE_DEGREE - sweepAngle - MIN_SWEEP_ANGLE
        }
        canvas.drawArc(viewBounds, startAngle, sweepAngle, false, paint)
    }

    override fun start() {
        if (isRunning) {
            return
        }
        isAnimationRunning = true
        angleAnimator.start()
        with(sweepAnimator) {
            addListener(sweepAnimatorListener)
            start()
        }
        invalidateSelf()
    }

    override fun stop() {
        if (!isRunning) {
            return
        }
        isAnimationRunning = false
        angleAnimator.cancel()
        with(sweepAnimator) {
            removeListener(sweepAnimatorListener)
            cancel()
        }
        invalidateSelf()
    }

    override fun onBoundsChange(bounds: Rect) {
        super.onBoundsChange(bounds)
        val outsideThickness = progressThickness / 2

        viewBounds.left = bounds.left + outsideThickness
        viewBounds.right = bounds.right - outsideThickness
        viewBounds.top = bounds.top + outsideThickness
        viewBounds.bottom = bounds.bottom - outsideThickness
    }

    override fun isRunning(): Boolean {
        return isAnimationRunning
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSPARENT
    }

    companion object {
        private const val ANGLE_ANIMATOR_DURATION = 1000L
        private const val SWEEP_ANIMATOR_DURATION = 1000L
        private const val MIN_SWEEP_ANGLE = 30f
        private const val FULL_CIRCLE_DEGREE = 360f
    }
}
