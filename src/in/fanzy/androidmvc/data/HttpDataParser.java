/**
 * 
 */
package in.fanzy.androidmvc.data;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Parses the data and returns back the main data you are looking for. Extend
 * and create a singleton & add all the maps.
 * 
 * @author gautham
 * 
 */
public class HttpDataParser {
	private static final String DEBUG_TAG = "HttpDataParser";
	// Following Data to DataObject mapping.
	protected HashMap<String, Class> mSingularStringDataClassMap = new HashMap<String, Class>();;
	protected HashMap<String, Class> mPluralStringDataClassMap = new HashMap<String, Class>();

	public <T extends AbstractData> ArrayList<T> parseAndReturnArray(
			JSONObject response, Class<T> returnClass, HttpDataHolder dataHolder) {
		ArrayList<T> returnList = null;
		for (String dataStr : mPluralStringDataClassMap.keySet()) {
			Class<T> dataClass = mPluralStringDataClassMap.get(dataStr);
			if (response.has(dataStr)) {
				try {
					ArrayList<T> dataObtained = parseDataObject(
							response.getJSONArray(dataStr), dataClass);
					if (returnClass != null
							&& dataClass.getCanonicalName() == returnClass.getCanonicalName()) {
						returnList = dataObtained;

					}
					dataHolder.addDataObjects(dataClass, dataObtained);

				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}

		return returnList;
	}

	@SuppressWarnings("unchecked")
	public <T extends AbstractData> T parseAndReturnObject(JSONObject response,
			Class<T> returnClass, HttpDataHolder dataHolder) {
		// As usual get all arrays.
		parseAndReturnArray(response, null, dataHolder);

		T returnDataObj = null;
		for (String dataStr : mSingularStringDataClassMap.keySet()) {
			Class dataClass = mSingularStringDataClassMap.get(dataStr);
			if (response.has(dataStr)) {
				try {
					T dataObj;
					dataObj = (T) parseDataObject(response.getJSONObject(dataStr),
							dataClass, dataHolder);
					dataHolder.addDataObject(dataObj, dataClass);
					if (returnClass != null
							&& returnClass.getCanonicalName() == dataClass.getCanonicalName()) {
						returnDataObj = dataObj;
					}

				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}

		// Return null otherwise.
		return returnDataObj;
	}

	private <T> ArrayList<T> parseDataObject(JSONArray jsonArray,
			Class<T> dataClass) {
		ArrayList<T> data = new ArrayList<T>();
		int length = jsonArray.length();
		for (int i = 0; i < length; i++) {
			try {
				JSONObject row = jsonArray.getJSONObject(i);
				InterfaceData dataObject = (InterfaceData) dataClass.newInstance();
				dataObject.parseJSON(row);
				data.add(dataClass.cast(dataObject));
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data;
	}

	private <T extends AbstractData> Object parseDataObject(
			JSONObject jsonObject, Class<T> dataClass, HttpDataHolder dataHolder) {
		try {
			long id = jsonObject.getLong(AbstractData.STR_ID);
			// If the object is available, re use it. Else create new.
			AbstractData dataObject = dataHolder.getDataObject(dataClass, id);
			if (dataObject == null) {
				dataObject = dataClass.newInstance();
			}

			dataObject.parseJSON(jsonObject);
			return dataClass.cast(dataObject);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
