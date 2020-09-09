package com.cast.serviceman.server.service;

import com.cast.serviceman.api.service.ServiceAsync;

import java.util.concurrent.CompletableFuture;

/**
 *
 * @Classname ServiceAsyncImpl
 * @Description 异步调用示例
 * @Date 2020/7/2 13:49
 * @author wanglei
 */
public class ServiceAsyncImpl implements ServiceAsync {

    @Override
    public CompletableFuture<String> callAsync(String name) {
        return null;
    }
}
