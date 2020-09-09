package com.cast.serviceman.api.service;

import java.util.concurrent.CompletableFuture;

/**
 * @Classname ServiceAsync
 * @Description 异步调用的示例，如果需要异步调用则可按照这个模式来搞
 * @Date 2020/7/1 15:53
 * @author by wanglei
 */
public interface ServiceAsync {
	/**
	 * 异步调用接口
	 * @param name 传入参数
	 * @return CompletableFuture 异步调用对象
	 */
	CompletableFuture<String> callAsync(String name);
}
