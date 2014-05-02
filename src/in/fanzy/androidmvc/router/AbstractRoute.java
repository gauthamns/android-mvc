/**
 * 
 */
package in.fanzy.androidmvc.router;

import in.fanzy.androidmvc.constants.Constants;
import in.fanzy.androidmvc.data.AbstractData;
import in.fanzy.androidmvc.data.RequestParams;
import in.fanzy.androidmvc.net.RequestDataFetcher;
import in.fanzy.androidmvc.view.UIBuilder;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Response;
import com.android.volley.VolleyError;

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
	public UIBuilder getUIBuilder(Activity activity) {
		mUIBuilder = createUIBuilder(activity);
		return mUIBuilder;
	}

	protected abstract UIBuilder createUIBuilder(Activity activity);

	@Override
	public void onDataResponse(JSONObject response) {
		if (dataType() == DATA_TYPE_LIST) {
			mUIBuilder.onListDataObtained(parseListJSON(response));
		} else {
			mUIBuilder.onDataObtained(parseObjectJSON(response));
		}
	}

	protected abstract int dataType();

	protected <T extends AbstractData> List<T> parseListJSON(JSONObject response) {
		return null;
	}

	protected <T extends AbstractData> T parseObjectJSON(JSONObject response) {
		return null;
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

	private Response.ErrorListener createErrorListener() {
		return new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				mUIBuilder.onDataFetchError(error);
			}
		};
	}

	private Response.Listener<JSONObject> createResponseListener() {
		return new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				onDataResponse(response);
			}
		};
	}

	@Override
	public void fetchData(boolean isRefreshAction, RequestDataFetcher dataFetcher)
			throws JSONException {
		List<RequestParams> params = getListRequestParams();

		// Fetch data if required. If params are given, then data needs to be
		// fetched.
		if (params != null & dataType() > 0) {
			dataFetcher.handleJSONObjectRequest(params, createResponseListener(),
					createErrorListener());
			mUIBuilder.onPreDataFetch(isRefreshAction);
		}
	}

	/**
	 * For only one request params by the routes.
	 * 
	 * @return
	 */
	public abstract RequestParams getRequestParams();
}
