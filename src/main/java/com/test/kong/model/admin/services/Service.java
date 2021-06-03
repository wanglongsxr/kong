package com.test.kong.model.admin.services;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @auther: wanglong
 * @date: 2021/6/3 15:56
 * @version: 1.0
 */
@Data @Builder public class Service {
    private String id;
    private String name;
    private String protocol;
    private String host;
    private Integer port;
    private String path;
    private String url;
    private Integer retries;
    @SerializedName("connect_timeout") private Long connectTimeout;
    @SerializedName("read_timeout") private Long readTimeout;
    @SerializedName("write_timeout") private Long writeTimeout;
    @SerializedName("created_at") private Long createdAt;
    @SerializedName("updated_at") private Long updatedAt;
}