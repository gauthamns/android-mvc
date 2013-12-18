/**
 * 
 */
package in.fanzy.androidmvc.router;

import in.fanzy.androidmvc.data.RequestParams;
import android.os.Bundle;

/**
 * Base class for all of the route.
 * 
 * @author gautham
 * 
 */
public abstract class Route {
	private Bundle mRequestBundle;

	public Route() {

	}

	public void setRequestBundle(Bundle requestBundle) {
		mRequestBundle = requestBundle;
	}

	/**
	 * Obtain the request Params necessary for obtaining data with the help of
	 * volley.
	 * 
	 * @return
	 */
	public abstract RequestParams getRequestParams();

}
