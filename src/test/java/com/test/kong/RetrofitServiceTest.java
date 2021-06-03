package com.test.kong;

import com.test.kong.model.admin.routes.Route;
import com.test.kong.model.admin.services.Service;
import com.test.kong.model.common.CommonList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @auther: wanglong
 * @date: 2021/6/3 16:12
 * @version: 1.0
 */
public class RetrofitServiceTest extends BaseTest {
    public static final String EXAMPLE_SERVICE = "example-service";

    @Test public void createServiceAndRouteTest() {

        // 删除Route和Service
        CommonList<Route> commonList = kongClient.getRouteService().listRoutesByService(EXAMPLE_SERVICE);
        List<Route> routeList = commonList.getData();
        if (null != routeList && routeList.size() > 0) {
            for (Route route : routeList) {
                kongClient.getRouteService().DeleteRoute(route.getId());
            }
        }
        kongClient.getServiceService().deleteService(EXAMPLE_SERVICE);

        // 新建Service和Route
        Service service = Service.builder().url("http://mockbin.org").name(EXAMPLE_SERVICE).build();
        Service response4service = kongClient.getServiceService().addService(service);
        printJson(response4service);
        List<String> hostList = new ArrayList<>();
        hostList.add("example.com");
        Route route = Route.builder().hosts(hostList).service(Service.builder().id(response4service.getId()).build()).build();
        Route response4route = kongClient.getRouteService().addRoute(route);
        printJson(response4route);
    }
}