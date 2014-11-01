///**
// * 
// */
//package in.fanzy.androidmvc.net;
//
//import in.fanzy.androidmvc.data.RequestParams;
//
//import java.util.Iterator;
//import java.util.List;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import android.util.Log;
//
//import com.android.volley.DefaultRetryPolicy;
//import com.android.volley.Request.Method;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response.ErrorListener;
//import com.android.volley.Response.Listener;
//import com.android.volley.toolbox.JsonObjectRequest;
//
///*
// * Abstract Class used to fetch data from internet with the help of Volley
// * volley. Extend this class and make it singleton to use in your app.
// * 
// * @author gautham
// * 
// */
//public abstract class RequestDataFetcher {
//	static final Object sLock = new Object();
//	private static final int INITIAL_TIMEOUT_MS = 5000;
//	static RequestDataFetcher sInstance;
//
//	public static String DEBUG_TAG = "RequestDataFetcher";
//	private final RequestQueue mRequestQueue;
//
//	protected RequestDataFetcher(RequestQueue queue) {
//		mRequestQueue = queue;
//	}
//
//	public void handleJSONObjectRequest(List<RequestParams> rpList,
//			Listener<JSONObject> listener, ErrorListener errorListener)
//			throws JSONException {
//		// First obtain RequestParams from the type and bundle.
//
//		for (RequestParams params : rpList) {
//			handleJSONObjectRequest(params, listener, errorListener);
//		}
//	}
//
//	public void handleJSONObjectRequest(RequestParams params,
//			Listener<JSONObject> listener, ErrorListener errorListener)
//			throws JSONException {
//
//		enhanceRequestParams(params);
//		JSONObject json = params.jsonRequest;
//		if (params.method == Method.GET && json != null) {
//			Iterator iterator = json.keys();
//			if (iterator.hasNext()) {
//				// Has keys. Add them.
//				params.url += "?";
//
//				while (iterator.hasNext()) {
//					String key = (String) iterator.next();
//					String value;
//
//					if (json.get(key) instanceof JSONArray) {
//						JSONArray array = json.getJSONArray(key);
//						value = array.join(",");
//
//					} else {
//						value = json.getString(key);
//					}
//					params.url += key + "=" + value + "&";
//				}
//
//				// Remove the last &.
//				params.url = params.url.substring(0, params.url.length() - 1);
//			}
//		}
//
//		JsonObjectRequest request = new JsonObjectRequest(params.method,
//				params.url, params.jsonRequest, listener, errorListener);
//
//		// No retries. Retries are hogging the server.
//		request.setRetryPolicy(new DefaultRetryPolicy(INITIAL_TIMEOUT_MS, 0, 10f));
//		Log.d(DEBUG_TAG, "Handling the http request to url " + params.url);
//		mRequestQueue.add(request);
//	}
//
//	/**
//	 * If you want to
//	 * 
//	 * @param params
//	 */
//	public abstract void enhanceRequestParams(RequestParams params)
//			throws JSONException;
// }
