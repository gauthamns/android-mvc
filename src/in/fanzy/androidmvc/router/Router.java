/**
 * 
 */
package in.fanzy.androidmvc.router;

import in.fanzy.androidmvc.constants.Constants;

import java.util.HashMap;

import android.content.Context;
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
	public Route getRoute(String routeStr, Bundle requestBundle, Context context) {
		Class routeCls = mRouteClassMap.get(routeStr);

		if (routeCls == null) {
			routeCls = getDefaultRouteClass();
		}

		Route route;
		try {
			route = (Route) routeCls.newInstance();
			// Set the bundle which contains data needed.
			route.setContext(context);

			if (requestBundle == null) {
				requestBundle = new Bundle();
			}

			requestBundle.putString(Constants.STR_ROUTE, routeStr);
			route.setRequestBundle(requestBundle);
			return route;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public abstract Class getDefaultRouteClass();
}
