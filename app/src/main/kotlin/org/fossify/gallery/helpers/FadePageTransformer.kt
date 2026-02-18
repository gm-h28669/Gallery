package org.fossify.gallery.helpers

import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

class FadePageTransformer : ViewPager.PageTransformer {
    override fun transformPage(view: View, position: Float) {
        view.translationX = view.width * -position

        if (position <= -1f || position >= 1f) {
            view.alpha = 0f
        } else if (position == 0f) {
            view.alpha = 1f
        } else {
            // Use hardware layer for smoother animation during the transition
            if (view.layerType != View.LAYER_TYPE_HARDWARE) {
                view.setLayerType(View.LAYER_TYPE_HARDWARE, null)
            }
            view.alpha = 1f - abs(position)
        }

        // Clear hardware layer when animation is essentially finished
        if (abs(position) < 0.01f || abs(position) > 0.99f) {
            if (view.layerType != View.LAYER_TYPE_NONE) {
                view.setLayerType(View.LAYER_TYPE_NONE, null)
            }
        }
    }
}
