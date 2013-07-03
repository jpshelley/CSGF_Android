package org.krellinst.csgf.fragments;

import org.krellinst.csgf.R;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AgendaFragment extends Fragment {
	public static final String ARG_POSITION = "position";

	private String url = "http://www.krellinst.org/conf/agenda/csgf/genhtml/full";

	private class MyWebViewClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	}

	@Override
	@SuppressLint("SetJavaScriptEnabled")
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.fragment_agenda, container, false);
		int i = getArguments().getInt(ARG_POSITION);

		WebView myWebView = (WebView) view.findViewById(R.id.webview);
		MyWebViewClient client = new MyWebViewClient();
		myWebView.setWebViewClient(client);
		WebSettings webSettings = myWebView.getSettings();
		webSettings.setBuiltInZoomControls(true);
		webSettings.setJavaScriptEnabled(true);
		myWebView.loadUrl(url);
		return view;
	}

}
