/**
 * 
 */
package in.fanzy.androidmvc.router;

import in.fanzy.androidmvc.constants.Constants;
import in.fanzy.androidmvc.data.RequestParams;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<RequestParams> getListRequestParams() {
		// By default, see if they send getRequestParams are there and use.
		RequestParams params = getRequestParams();
		List<RequestParams> rpList = new ArrayList<RequestParams>();
		if (params != null) {
			rpList.add(params);
		}

		return rpList;
	}

	/**
	 * For only one request params by the routes.
	 * 
	 * @return
	 */
	public abstract RequestParams getRequestParams();
}
