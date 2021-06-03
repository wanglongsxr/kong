package com.test.kong.internal.admin;

import com.test.kong.model.admin.services.Service;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @description:
 * @auther: wanglong
 * @date: 2021/6/3 16:01
 * @version: 1.0
 */
public interface RetrofitServiceService {

    @POST("services/") Call<Service> addService(@Body Service request);

    @DELETE("services/{nameOrId}") Call<Void> deleteService(@Path("nameOrId") String nameOrId);
}