/**
 * 
 */
package in.fanzy.androidmvc.view;

import in.fanzy.androidmvc.data.HttpDataResponseInterface;
import retrofit.RetrofitError;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Abstract class for building UI. Activity will take help of the UI builder to
 * build the UI.
 * 
 * @author gautham
 * 
 */
public abstract class AbstractUIBuilder implements UIBuilder {
	public final Activity mActivity;

	public AbstractUIBuilder(Activity activity) {
		mActivity = activity;
	}

	@Override
	public void onDataFetchError(RetrofitError error) {
	}

	@Override
	public <T extends HttpDataResponseInterface> void onDataObtained(
			T dataResponse) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPreDataFetch(boolean isRefreshAction) {
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
