/**
 * 
 */
package in.fanzy.androidmvc.data;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Interface every data object should implement.
 * 
 * @author gautham
 * 
 */
public interface InterfaceData {

	public void parseJSON(JSONObject json) throws JSONException;

	// public <T extends HttpDataResponseInterface> void setRelatedData(T data);
}
