/**
 * 
 */
package in.fanzy.androidmvc.router;

import java.util.HashMap;

import android.os.Bundle;

/**
 * Base class for Router for defining all the routes.
 * 
 * @author gautham
 * 
 */
public abstract class Router {

	// Hash for Matching Id to the class.
	protected static HashMap<String, Class> mRouteClassMap;
	static {
		mRouteClassMap = new HashMap<String, Class>();
	}

	/**
	 * No arguments constructor.
	 */
	public Router() {
	}

	/**
	 * 
	 * @param routeStr
	 *          String corresponding to the route.
	 * @return Route object if found. else returns null.
	 */
	public AbstractRoute getRoute(String routeStr, Bundle requestBundle) {
		Class routeCls = mRouteClassMap.get(routeStr);

		if (routeCls == null) {
			return null;
		}

		AbstractRoute route;
		try {
			route = (AbstractRoute) routeCls.newInstance();
			// Set the bundle which contains data needed.
			route.setRequestBundle(requestBundle);
			return route;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// If came here, wrong class given. Return null.
		return null;
	}
}
