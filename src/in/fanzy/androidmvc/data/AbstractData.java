/**
 * 
 */
package in.fanzy.androidmvc.data;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Abstract data object. Above all data objects for generic content provider.
 * 
 * @author gautham
 * 
 */
public abstract class AbstractData implements InterfaceData {
	public long id;
	public long updatedTime;

	public static final String STR_ID = "id";

	@Override
	public void parseJSON(JSONObject row) throws JSONException {
		if (!row.isNull(STR_ID)) {
			id = row.getLong(STR_ID);
		}
		updatedTime = System.currentTimeMillis();
	}
}
