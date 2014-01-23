package in.fanzy.androidmvc.view;

import in.fanzy.androidmvc.data.AbstractData;

import java.util.List;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.VolleyError;

public interface UIBuilder {

	public void onDataFetchError(VolleyError error);

	/**
	 * Build the UI.
	 */
	public void buildUI();

	/**
	 * Set the title for the current handling page.
	 */
	public void setTitle();

	public void onPreDataFetch(boolean isRefreshAction);

	/**
	 * After data is obtained.
	 * 
	 * @param <T>
	 * 
	 * @param response
	 */
	public <T extends AbstractData> void onDataObtained(T data);

	/**
	 * After data is obtained & if it is a list.
	 * 
	 * @param <T>
	 * 
	 * @param response
	 */
	public <T extends AbstractData> void onListDataObtained(List<T> data);

	/**
	 * To build the menu.
	 * 
	 * @param menu
	 */
	public void onActivityCreateOptionsMenu(Menu menu);

	/**
	 * If any of option is selected.
	 * 
	 * @param item
	 * @return
	 */
	public boolean onActivityOptionsItemSelected(MenuItem item);

	public void onActivityPause();

	public void onActivityResume();

	public void onActivityStart();

	public void onActivityStop();

	// To override onActivityResult.
	public void onActivityResult(int requestCode, int resultCode, Intent data);
}
