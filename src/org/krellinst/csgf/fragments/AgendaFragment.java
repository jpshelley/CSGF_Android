package org.krellinst.csgf.fragments;

import org.krellinst.csgf.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AgendaFragment extends Fragment {
	public static final String ARG_POSITION = "position";

	public AgendaFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.fragment_agenda, container, false);
		int i = getArguments().getInt(ARG_POSITION);

		Button button = (Button) view.findViewById(R.id.agendaButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("PRINTING");
			}
		});
		return view;
	}

}
