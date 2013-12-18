/**
 * 
 */
package in.fanzy.androidmvc.router;

import android.os.Bundle;

/**
 * Base class for all of the route.
 * 
 * @author gautham
 * 
 */
public abstract class AbstractRoute implements Route {
	private Bundle mRequestBundle;

	public AbstractRoute() {

	}

	public void setRequestBundle(Bundle requestBundle) {
		mRequestBundle = requestBundle;
	}

}
