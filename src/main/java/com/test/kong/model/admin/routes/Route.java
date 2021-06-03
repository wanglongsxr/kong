package com.test.kong.model.admin.routes;

import com.google.gson.annotations.SerializedName;
import com.test.kong.model.admin.services.Service;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @auther: wanglong
 * @date: 2021/6/3 16:03
 * @version: 1.0
 */
@Data @Builder public class Route {
    private String id;
    private List<String> protocols;
    private List<String> methods;
    private List<String> hosts;
    private List<String> paths;
    @SerializedName("strip_path") private Boolean stripPath;
    @SerializedName("preserve_host") private Boolean preserveHost;
    private Service service;
    @SerializedName("created_at") private Long createdAt;
    @SerializedName("updated_at") private Long updatedAt;
}