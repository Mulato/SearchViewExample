package com.carloscavalcanti.searchexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements SearchView.OnQueryTextListener  {
	
	private SearchView mSearchView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		
		 MenuItem searchItem = menu.findItem(R.id.action_search);
	     mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
	     mSearchView.setOnQueryTextListener(this);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		/*if (id == R.id.action_search) {
			mSearchView.setIconified(false);
			return true;
		}*/
		return super.onOptionsItemSelected(item);
	}

	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	@Override
	public boolean onQueryTextChange(String text) {
		Toast.makeText(this, "onQueryTextChange - " + text, Toast.LENGTH_LONG).show();
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String text) {
		Toast.makeText(this, "onQueryTextSubmit - " + text, Toast.LENGTH_LONG).show();
		return false;
	}

}
