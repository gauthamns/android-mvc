package in.fanzy.androidmvc.net;

import java.util.Map;

import retrofit.Callback;
import retrofit.http.QueryMap;

public interface RequestMakerInterface {
	<T> void fetch(@QueryMap Map<String, String> options, Callback<T> cb);

}
