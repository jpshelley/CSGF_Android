package org.krellinst.csgf;

import org.krellinst.csgf.fragments.AgendaFragment;
import org.krellinst.csgf.fragments.WelcomeFragment;
import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainCSGF extends FragmentActivity {

	public Typeface tf;

	/* Layouts */
	public LinearLayout menuListLayout;

	/* Fragments */
	private static final int Welcome = 0;
	private static final int Agenda = 1;

	/* Drawer */
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;

	private String[] mCategories;
	private int[] mImage;
	private ListView mDrawerList;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;

	@Override
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main_csgf);

		mTitle = mDrawerTitle = getTitle();
		mCategories = getResources().getStringArray(R.array.drawer_list);
		mImage = new int[] { R.drawable.ic_menu_info_details,
				android.R.drawable.ic_menu_today,
				R.drawable.ic_menu_allfriends,
				android.R.drawable.ic_menu_mapmode, R.drawable.ic_menu_home,
				android.R.drawable.ic_menu_camera };
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			/* Called when a drawer has settled in a completely closed state */
			public void onDrawerClosed(View v) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // Creates call to
											// onPrepareOptionsMenu()
			}

			/* Called when a drawer has settled in completely open state */
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // Creates call to onPrepare

			}
		};
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		/* Sets the adapter for the list view */
		
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, mCategories));

		/* Set the lists click listener */
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		tf = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");

	}

	/* The click listner for ListView in the navigation drawer */
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	private void selectItem(int position) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		Bundle args = new Bundle();

		if (position == Welcome) {
			fragment = new WelcomeFragment();
			args.putInt(WelcomeFragment.ARG_POSITION, position);

		} else if (position == Agenda) {
			fragment = new AgendaFragment();
			args.putInt(AgendaFragment.ARG_POSITION, position);

		} else if (position == 2) {
			fragment = new Fragment();
			// args.putInt(Fragment.ARG_PLANET_NUMBER, position);

		} else if (position == 3) {
			fragment = new Fragment();
			// args.putInt(Fragment.ARG_PLANET_NUMBER, position);

		} else if (position == 4) {
			fragment = new Fragment();
			// args.putInt(Fragment.ARG_PLANET_NUMBER, position);

		} else if (position == 5) {
			fragment = new Fragment();
			// args.putInt(Fragment.ARG_PLANET_NUMBER, position);

		} else if (position == 6) {
			fragment = new Fragment();
			// args.putInt(Fragment.ARG_PLANET_NUMBER, position);

		}
		fragment.setArguments(args);

		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment).commit();

		// update selected item and title, then close the drawer
		mDrawerList.setItemChecked(position, true);
		setTitle(mCategories[position]);
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	/* Called whenever we call invalidateOptionsMenu() */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// If the nav drawer is open, hide action items related to the content
		// view
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		// menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_csg, menu);
		return true;
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Pass the event to ActionBarDrawerToggle, if it returns
		// true, then it has handled the app icon touch event
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle your other action bar items...

		return super.onOptionsItemSelected(item);
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
}
