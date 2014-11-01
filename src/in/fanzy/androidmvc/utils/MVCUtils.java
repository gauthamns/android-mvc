package in.fanzy.androidmvc.utils;

import in.fanzy.androidmvc.data.AbstractData;

import java.util.ArrayList;
import java.util.List;

public class MVCUtils {

	public static <T extends AbstractData> ArrayList<T> getList(
			Class<T> dataClass, List<Long> idList, List<T> dataList) {

		ArrayList<T> returnList = new ArrayList<T>();

		if (idList != null && idList.size() > 0 && dataList != null
				&& dataList.size() > 0) {
			for (T data : dataList) {
				if (listContains(idList, data.id)) {
					returnList.add(data);
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

	public static <T extends AbstractData> T getItem(Class<T> dataClass, long id,
			List<T> dataList) {
		T returnData = null;

		if (dataList != null && dataList.size() > 0) {
			for (T data : dataList) {
				if (data.id == id) {
					returnData = data;
				}
			}
		}

		return returnData;
	}
}
