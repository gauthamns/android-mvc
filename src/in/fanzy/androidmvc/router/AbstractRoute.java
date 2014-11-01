/**
 * 
 */
package in.fanzy.androidmvc.router;

import in.fanzy.androidmvc.constants.Constants;
import in.fanzy.androidmvc.view.UIBuilder;

import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Base class for all of the route.
 * 
 * @author gautham
 * 
 */
public abstract class AbstractRoute implements Route {
	protected Bundle mRequestBundle;
	protected UIBuilder mUIBuilder;
	protected Context mContext;

	public static final int DATA_TYPE_LIST = 1;
	public static final int DATA_TYPE_OBJECT = 2;

	@Override
	public void setContext(Context context) {
		mContext = context;
	}

	@Override
	public void setRequestBundle(Bundle requestBundle) {
		mRequestBundle = requestBundle;
	}

	@Override
	public Bundle getRequestBundle() {
		return mRequestBundle;
	}

	/**
	 * Intent, and transition to the Route.
	 */
	@Override
	public void transitionTo() {
		Intent i = new Intent(mContext, getActivityClass());
		i.putExtra(Constants.STR_REQUEST_BUNDLE, mRequestBundle);
		mContext.startActivity(i);
	}

	public void addParamsToMap(Map<String, String> map, String[] paramsStr) {
		for (String str : paramsStr) {
			map.put(str, String.valueOf(mRequestBundle.get(str)));
		}
	}

	@Override
	public UIBuilder getUIBuilder(Activity activity) {
		mUIBuilder = createUIBuilder(activity);
		return mUIBuilder;
	}

	protected abstract UIBuilder createUIBuilder(Activity activity);
}
