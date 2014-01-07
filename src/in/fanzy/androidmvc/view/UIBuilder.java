package in.fanzy.androidmvc.view;

import org.json.JSONObject;

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
	 * Once volley response is obtained.
	 * 
	 * @param response
	 */
	public void onDataResponse(JSONObject response);

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
