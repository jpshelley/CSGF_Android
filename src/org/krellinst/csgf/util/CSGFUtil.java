package org.krellinst.csgf.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;

public class CSGFUtil {

	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	public static Point getScreenSize(Activity a) {

		Display display = a.getWindowManager().getDefaultDisplay();
		Point size = new Point();
		if (versionGreaterThan(Build.VERSION_CODES.HONEYCOMB_MR1))
			display.getRealSize(size);
		else {
			size.x = display.getWidth();
			size.y = display.getHeight();
		}

		return size;
	}

	public static int getScreenHeight(Activity a) {
		return getScreenSize(a).y;
	}

	public static int getScreenWidth(Activity a) {
		return getScreenSize(a).x;
	}

	/*
	 * for reference visit
	 * http://developer.android.com/guide/topics/manifest/uses
	 * -sdk-element.html#ApiLevels
	 */
	public static boolean versionGreaterThan(int minV) {
		return android.os.Build.VERSION.SDK_INT >= minV;
	}
}
