package com.blazingwin.ber.api;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.POST;
import rx.Observable;

public interface Api {

   @POST("zPgVjftj")
   Observable<Response<ResponseBody>> sendRequest();
}
