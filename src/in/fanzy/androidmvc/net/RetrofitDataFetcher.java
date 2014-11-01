package in.fanzy.androidmvc.net;

import java.util.Map;

import retrofit.Callback;
import retrofit.RestAdapter;

public class RetrofitDataFetcher {

	public static <T extends RequestMakerInterface> void handleRequest(
			RestAdapter restAdapter, Callback cb, Class<T> serviceClass,
			Map<String, String> queryMap) {
		T service = restAdapter.create(serviceClass);

		service.fetch(queryMap, cb);
	}
}
