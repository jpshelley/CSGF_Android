package org.krellinst.csgf;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

import org.krellinst.csgf.util.CSGFUtil;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.widget.LinearLayout;

public class MainCSGF extends FragmentActivity {

	public Typeface tf;

	/* Layouts */
	public LinearLayout menuListLayout;

	/* Fragments */
	private static final int Welcome = 0;
	private static final int Fragment_Count = Welcome + 1;
	private Fragment[] fragments = new Fragment[Fragment_Count];
	private MenuDrawer sideDrawer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main_csgf);

		/* Setup the fragments */
		FragmentManager fm = getSupportFragmentManager();
		fragments[Welcome] = fm.findFragmentById(R.id.welcomeFragment);
		FragmentTransaction trans = fm.beginTransaction();
		for (int i = 0; i < fragments.length; i++) {
			if (fragments[i] != null) {
				trans.hide(fragments[i]);
			}
		}
		trans.commit();
		tf = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");

		addMenuDrawers();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_csg, menu);
		return true;
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onResumeFragments() {
		super.onResumeFragments();
	}

	@Override
	public void onSaveInstanceState(Bundle bundle) {
		super.onSaveInstanceState(bundle);
	}

	private void showFragment(int fragmentIndex, boolean addToBackStack) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction trans = fm.beginTransaction();
		for (int i = 0; i < fragments.length; i++) {
			if (i == fragmentIndex) {
				trans.show(fragments[i]);
			} else {
				trans.hide(fragments[i]);
			}
		}
		trans.commit();
	}

	private void addMenuDrawers() {
		/* Add the sliding menu panel */
		sideDrawer = MenuDrawer.attach(this, Position.LEFT);
		sideDrawer.setMenuSize((int) (CSGFUtil.getScreenWidth(this) * .50));
		sideDrawer.setMenuView(R.layout.menu_scrollview);
		menuListLayout = (LinearLayout) findViewById(R.id.menuListLayout);
	}
}
