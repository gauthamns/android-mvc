/**
 * 
 */
package in.fanzy.androidmvc.router;

import in.fanzy.androidmvc.constants.Constants;
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

	public AbstractRoute(Context context) {
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
}
