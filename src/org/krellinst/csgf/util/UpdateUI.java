package org.krellinst.csgf.util;

import org.krellinst.csgf.R.color;

import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.TextView;

public class UpdateUI {

	/**
	 * Helps create the font
	 * 
	 * @param tf
	 * @param view
	 */
	public static void setTypeFace(Typeface tf, TextView view) {
		view.setTypeface(tf);
		view.setTextSize(24);
		view.setTextColor(color.Black);
		view.setGravity(Gravity.CENTER);
	}

	/**
	 * Helps create the font
	 * 
	 * @param tf
	 * @param view
	 */
	public static void setTypeFace(Typeface tf, TextView view, int color) {
		view.setTypeface(tf);
		view.setTextSize(24);
		view.setTextColor(color);
		view.setGravity(Gravity.CENTER);
	}

}
