/**
 * 
 */
package in.fanzy.androidmvc.view;

import org.json.JSONObject;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.VolleyError;

/**
 * Abstract class for building UI. Activity will take help of the UI builder to
 * build the UI.
 * 
 * @author gautham
 * 
 */
public abstract class AbstractUIBuilder implements UIBuilder {
	public final FragmentActivity mActivity;

	public AbstractUIBuilder(FragmentActivity activity) {
		mActivity = activity;
	}

	@Override
	public void onDataFetchError(VolleyError error) {
	}

	@Override
	public void onPreDataFetch(boolean isRefreshAction) {
	}

	@Override
	public void onDataResponse(JSONObject response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActivityCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onActivityOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onActivityPause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActivityResume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActivityStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActivityStop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Stub.
	}
}
