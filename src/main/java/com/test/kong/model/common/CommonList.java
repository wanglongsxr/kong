package com.test.kong.model.common;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @auther: wanglong
 * @date: 2021/6/3 16:01
 * @version: 1.0
 */
@Data public class CommonList<T> extends AbstractEntityList {
    Long total;
    String next;
    List<T> data;
}
