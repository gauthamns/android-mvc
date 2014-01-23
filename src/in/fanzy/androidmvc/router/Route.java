package in.fanzy.androidmvc.router;

import in.fanzy.androidmvc.data.RequestParams;
import in.fanzy.androidmvc.net.RequestDataFetcher;
import in.fanzy.androidmvc.view.UIBuilder;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public interface Route {

	/**
	 * Obtain the request Params necessary for obtaining data with the help of
	 * volley. If null is provided, no request is made. TODO: Get data not only
	 * from net, but also from other sources like Database, files, preferences
	 * etc.
	 * 
	 * @return
	 */
	public List<RequestParams> getListRequestParams();

	/**
	 * Set the context required for the route.
	 * 
	 * @param context
	 */
	public void setContext(Context context);

	/**
	 * Once volley response is obtained.
	 * 
	 * @param response
	 */
	public void onDataResponse(JSONObject response);

	/**
	 * Bundle with necessary data. No need to have this now.
	 * 
	 * @param requestBundle
	 */
	public void setRequestBundle(Bundle requestBundle);

	/**
	 * Fetch the relevant data.
	 */
	public void fetchData(boolean isRefreshAction, RequestDataFetcher dataFetcher)
			throws JSONException;

	/**
	 * Activity which should be used for this Route.
	 * 
	 * @return Class name of the Activity.
	 */
	public Class getActivityClass();

	/**
	 * Transition to the route.
	 */
	public void transitionTo();

	/**
	 * Object which will build the UI for the provided Route.
	 * 
	 * @return
	 */
	public UIBuilder getUIBuilder(Activity activity);

}
