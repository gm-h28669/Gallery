package org.fossify.gallery.helpers

import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

class FadePageTransformer : ViewPager.PageTransformer {
    override fun transformPage(view: View, position: Float) {
        val absPos = abs(position)

        // Offset the default sliding transition to keep pages stacked
        view.translationX = view.width * -position

        if (position <= -1f || position >= 1f) {
            view.alpha = 0f
            view.setLayerType(View.LAYER_TYPE_NONE, null)
        } else if (position == 0f) {
            view.alpha = 1f
            view.setLayerType(View.LAYER_TYPE_NONE, null)
        } else {
            // Use hardware layer for smoother animation during the transition
            if (view.layerType != View.LAYER_TYPE_HARDWARE) {
                view.setLayerType(View.LAYER_TYPE_HARDWARE, null)
            }
            view.alpha = 1f - absPos
        }
    }
}
