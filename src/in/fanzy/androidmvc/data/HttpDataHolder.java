package in.fanzy.androidmvc.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Object to store all the http data obtained for a request as key value map.
 * Singleton so that can be shared across the app. But need to purge when
 * quitting.
 * 
 * @author gautham
 * @param <T>
 * 
 */
public abstract class HttpDataHolder {
	static final Object sLock = new Object();
	static HttpDataHolder sInstance;

	public HashMap<Class<? extends AbstractData>, HashMap<Long, AbstractData>> mMappingMap = new HashMap<Class<? extends AbstractData>, HashMap<Long, AbstractData>>();

	protected HttpDataHolder() {
		populateMappingMap();
	}

	public <T> T getObjectForId(long id, Class<T> dataClass) {
		return (T) mMappingMap.get(dataClass).get(id);
	}

	protected abstract void populateMappingMap();

	public void addDataObject(AbstractData data,
			Class<? extends AbstractData> dataClass) {
		long id = data.id;
		mMappingMap.get(dataClass).put(id, data);
	}

	public void addDataObjects(Class<? extends AbstractData> dataClass,
			List dataObtained) {

		HashMap<Long, AbstractData> dataToAddList = mMappingMap.get(dataClass);
		for (Object data : dataObtained) {
			AbstractData convertedData = dataClass.cast(data);

			dataToAddList.put(convertedData.id, convertedData);
		}
	}

	public <T extends AbstractData> T getDataObject(Class<T> dataClass, long id) {
		return (T) mMappingMap.get(dataClass).get(id);
	}

	public <T extends AbstractData> ArrayList<T> getList(Class<T> dataClass,
			List<Long> idArray) {

		ArrayList<T> returnList = new ArrayList<T>();
		HashMap<Long, AbstractData> mHashMap = mMappingMap.get(dataClass);

		if (idArray != null && idArray.size() > 0) {
			for (long id : mHashMap.keySet()) {
				if (listContains(idArray, id)) {
					returnList.add((T) mHashMap.get(id));
				}
			}
		}

		return returnList;
	}

	public static boolean listContains(List<Long> list, long id) {
		for (long value : list) {
			if (value == id) {
				return true;
			}
		}
		return false;
	}
}
