package org.krellinst.csgf.fragments;

import org.krellinst.csgf.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WelcomeFragment extends Fragment {
	final static String ARG_POSITION = "position";
	int mCurrentPosition = -1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_welcome, container,
				false);
		TextView welcomeText = (TextView) view.findViewById(R.id.welcomeText);
		welcomeText.setText("Welcome to CSGF 2013!");
		return view;
	}

	public void setText(String item) {
		TextView welcomeText = (TextView) getView().findViewById(
				R.id.welcomeText);
		welcomeText.setText(item);
	}
}
