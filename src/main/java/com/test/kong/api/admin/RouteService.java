package com.test.kong.api.admin;

import com.test.kong.model.admin.routes.Route;
import com.test.kong.model.common.CommonList;

/**
 * @description:
 * @auther: wanglong
 * @date: 2021/6/3 16:03
 * @version: 1.0
 */
public interface RouteService {
    Route addRoute(Route route);

    void DeleteRoute(String id);

    CommonList<Route> listRoutesByService(String name);
}
