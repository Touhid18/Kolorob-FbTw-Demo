/**
 * 
 */
package com.stc.touhidroid.kolorobfbtwdemo.utils;

import android.support.v4.view.ViewPager;
import android.view.View;


/**
 * @author Touhid
 * 
 */
public class DepthPageTransformer implements ViewPager.PageTransformer {
	private static final float MIN_SCALE = 0.5f;

	@Override
	public void transformPage(View view, float position) {
		int pageWidth = view.getWidth();
		// int pageHeight = view.getHeight();

		AnimatorProxy proxy = AnimatorProxy.wrap(view);

		if (position < -1) { // [-Infinity,-1)
			// This page is way off-screen to the left.
			proxy.setAlpha(0);

		} else if (position <= 0) { // [-1,0]
			// Use the default slide transition when moving to the left page
			proxy.setAlpha(1);
			proxy.setTranslationX(0);
			proxy.setScaleX(1);
			proxy.setScaleY(1);

		} else if (position <= 1) { // (0,1]
			// Fade the page out.
			proxy.setAlpha(1 - position);

			// Counteract the default slide transition
			proxy.setTranslationX(pageWidth * -position);

			// Scale the page down (between MIN_SCALE and 1)
			float scaleFactor = MIN_SCALE + (1 - MIN_SCALE)
					* (1 - Math.abs(position));
			proxy.setScaleX(scaleFactor);
			proxy.setScaleY(scaleFactor);

		} else { // (1,+Infinity]
			// This page is way off-screen to the right.
			proxy.setAlpha(0);
		}
	}
}
