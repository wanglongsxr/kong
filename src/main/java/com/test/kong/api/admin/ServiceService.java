package com.test.kong.api.admin;

import com.test.kong.model.admin.services.Service;

/**
 * @description:
 * @auther: wanglong
 * @date: 2021/6/3 15:59
 * @version: 1.0
 */
public interface ServiceService {

    Service addService(Service service);

    void deleteService(String nameOrId);
}