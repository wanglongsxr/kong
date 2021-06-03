package com.test.kong.impl;

import com.test.kong.api.admin.RouteService;
import com.test.kong.api.admin.ServiceService;
import com.test.kong.impl.helper.RetrofitServiceCreator;
import com.test.kong.internal.admin.RetrofitRouteService;
import com.test.kong.internal.admin.RetrofitServiceService;
import lombok.Data;

/**
 * @description:
 * @auther: wanglong
 * @date: 2021/6/3 15:59
 * @version: 1.0
 */
@Data public class KongClient {

    private ServiceService serviceService;
    private RouteService routeService;

    public KongClient(String adminUrl) {
        if (adminUrl == null || adminUrl.isEmpty()) {
            throw new IllegalArgumentException("The adminUrl cannot be null or empty!");
        }

        RetrofitServiceCreator retrofitServiceCreatorForAdminUrl = new RetrofitServiceCreator(adminUrl);

        {
            serviceService = retrofitServiceCreatorForAdminUrl.create(ServiceService.class, RetrofitServiceService.class);
            routeService = retrofitServiceCreatorForAdminUrl.create(RouteService.class, RetrofitRouteService.class);
        }
    }
}
