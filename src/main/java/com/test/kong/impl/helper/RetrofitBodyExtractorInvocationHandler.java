package com.test.kong.impl.helper;

import com.test.kong.exception.KongClientException;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @auther: wanglong
 * @date: 2021/6/3 15:59
 * @version: 1.0
 */
@Slf4j public class RetrofitBodyExtractorInvocationHandler implements InvocationHandler {

    private Object proxied;

    public RetrofitBodyExtractorInvocationHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Method method1 = proxied.getClass().getMethod(methodName, parameterTypes);
        Call call = (Call)method1.invoke(proxied, args);
        Response response = call.execute();
        log.debug("Http Request:  " + response.raw().request());
        log.debug("Http Response: " + response.raw().toString());
        if (!response.isSuccessful()) {
            throw new KongClientException(response.errorBody() != null ? response.errorBody().string() : String.valueOf(response.code()));
        }
        return response.body();
    }
}
