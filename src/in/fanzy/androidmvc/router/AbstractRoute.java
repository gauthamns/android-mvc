/**
 * 
 */
package in.fanzy.androidmvc.router;

import in.fanzy.androidmvc.constants.Constants;

import org.json.JSONException;
import org.json.JSONObject;

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
	protected Context mContext;

	@Override
	public void setContext(Context context) {
		mContext = context;
	}

	@Override
	public void setRequestBundle(Bundle requestBundle) {
		mRequestBundle = requestBundle;
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

	public void addParamsTojsonRequest(JSONObject jsonRequest, String[] paramsStr) {
		try {
			for (String str : paramsStr) {
				jsonRequest.put(str, mRequestBundle.get(str));
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
