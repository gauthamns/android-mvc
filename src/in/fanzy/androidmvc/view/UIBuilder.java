package in.fanzy.androidmvc.view;

import in.fanzy.androidmvc.data.HttpDataResponseInterface;
import retrofit.RetrofitError;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public interface UIBuilder {

	public void onDataFetchError(RetrofitError error);

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
	public <T extends HttpDataResponseInterface> void onDataObtained(
			T dataResponse);

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
