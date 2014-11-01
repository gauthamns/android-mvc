package in.fanzy.androidmvc.router;

import in.fanzy.androidmvc.data.HttpDataResponseInterface;
import in.fanzy.androidmvc.view.UIBuilder;
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
	// public List<RequestParams> getListRequestParams();

	/**
	 * Set the context required for the route.
	 * 
	 * @param context
	 */
	public void setContext(Context context);

	/**
	 * Bundle with necessary data. No need to have this now.
	 * 
	 * @param requestBundle
	 */
	public void setRequestBundle(Bundle requestBundle);

	/**
	 * Fetch the relevant data.
	 */
	public <T extends HttpDataResponseInterface> void fetchData(boolean isRefreshAction);

	/**
	 * Activity which should be used for this Route.
	 * 
	 * @return Class name of the Activity.
	 */
	public Class getActivityClass();

	/**
	 * Request bundle. Useful for situations where we will need to build pending
	 * intent.
	 * 
	 * @return
	 */
	public Bundle getRequestBundle();

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
