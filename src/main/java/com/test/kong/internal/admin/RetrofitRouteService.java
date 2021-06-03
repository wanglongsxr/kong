package com.test.kong.internal.admin;

import com.test.kong.model.admin.routes.Route;
import com.test.kong.model.common.CommonList;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * @description:
 * @auther: wanglong
 * @date: 2021/6/3 16:05
 * @version: 1.0
 */
public interface RetrofitRouteService {
    @POST("routes/") Call<Route> addRoute(@Body Route route);

    @DELETE("routes/{id}") Call<Void> DeleteRoute(@Path("id") String id);

    @GET("/services/{id}/routes") Call<CommonList<Route>> listRoutesByService(@Path("id") String id);
}