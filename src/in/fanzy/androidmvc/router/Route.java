package in.fanzy.androidmvc.router;

import in.fanzy.androidmvc.data.RequestParams;
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
	public RequestParams getRequestParams();

	/**
	 * Bundle with necessary data.
	 * 
	 * @param requestBundle
	 */
	public void setRequestBundle(Bundle requestBundle);

	/**
	 * Activity which should be used for this Route.
	 * 
	 * @return Class name of the Activity.
	 */
	public Class getActivityClass();

}
