/**
 * 
 */
package in.fanzy.androidmvc.data;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;

/**
 * @author gautham
 * 
 */
public class RequestParams {
	public static final String BUNDLE_EXTRA = "RequestParams.BUNDLE_EXTRA";
	private static final String STRING_URL = "URL";
	private static final String STRING_JSON_OBJECT = "JSON_OBJECT";
	private static final String STRING_METHOD = "METHOD";

	public String url;
	public JSONObject jsonRequest = null;
	public int method;

	public RequestParams() {

	}

	public RequestParams(Bundle bundle) throws JSONException {
		url = bundle.getString(STRING_URL);
		jsonRequest = new JSONObject(bundle.getString(STRING_JSON_OBJECT));
		method = bundle.getInt(STRING_METHOD);
	}

	public Bundle getBundleExtra() {
		Bundle bundle = new Bundle();
		bundle.putInt(STRING_METHOD, method);
		bundle.putString(STRING_JSON_OBJECT, jsonRequest.toString());
		bundle.putString(STRING_URL, url);
		return bundle;
	}
}
