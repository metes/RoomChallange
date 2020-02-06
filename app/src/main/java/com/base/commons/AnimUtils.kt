package com.base.commons

import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.dynamicanimation.animation.FloatPropertyCompat
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce


object AnimUtils {

    fun startFadeOutAnimation(view: View, duration: Long) {
        val fadeOut = AlphaAnimation(1f, 0f)
        fadeOut.interpolator = AccelerateInterpolator() // and this
        fadeOut.startOffset = Animation.RELATIVE_TO_SELF.toLong()
        fadeOut.duration = duration
        fadeOut.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                view.visibility = INVISIBLE
            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })
        view.startAnimation(fadeOut)
    }

    fun startFadeInAnimation(view: View, duration: Long) {
        view.visibility = VISIBLE
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = AccelerateInterpolator() // and this
        fadeIn.startOffset = Animation.RELATIVE_TO_SELF.toLong()
        fadeIn.duration = duration //ANIMATION_DURATION
        view.startAnimation(fadeIn)
    }

    private fun getFadeInAnimation(duration: Long): Animation {
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = AccelerateInterpolator() // and this
        fadeIn.startOffset = Animation.RELATIVE_TO_SELF.toLong()
        fadeIn.duration = duration //ANIMATION_DURATION        //Math.round(duration * 0.4f));
        return fadeIn
    }

    fun startSpringResize(view: View?) {
        view?.let {
            it.startAnimation(getFadeInAnimation(300L))
            getSpringAnimation(it, SpringAnimation.SCALE_X, 2.8f).start()
            getSpringAnimation(it, SpringAnimation.SCALE_Y, 2.8f).start()
        }
    }

    private fun getSpringAnimation(
        view: View,
        springAnimationType: FloatPropertyCompat<View>,
        finalPosition: Float
    ): SpringAnimation {
        val animation = SpringAnimation(view, springAnimationType)
        // create a spring with desired parameters
        val spring = SpringForce()
        spring.finalPosition = finalPosition
        spring.stiffness = SpringForce.STIFFNESS_VERY_LOW // optional
        spring.dampingRatio = SpringForce.DAMPING_RATIO_LOW_BOUNCY // optional
        // set your animation's spring
        animation.spring = spring
        return animation
    }


}
