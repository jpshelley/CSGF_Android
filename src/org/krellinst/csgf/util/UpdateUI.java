package org.krellinst.csgf.util;

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
		view.setGravity(Gravity.CENTER);
	}

	/**
	 * Helps create the font
	 * 
	 * @param tf
	 * @param view
	 */
	public static void setTypeFace(Typeface tf, TextView view, int size) {
		view.setTypeface(tf);
		view.setTextSize(size);
		view.setGravity(Gravity.CENTER);
	}

}
