package com.tt.tm;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.SimpleTimeLimiter;

public class TestTimeLimiter {

	public static void main(String[] args) {

		//testDynamicProxy();
		testCallTimeOut();
	}

	/***
	 * 模拟动态代理
	 */
	public static void testDynamicProxy() {

		// 实例化一个线程服务
		ExecutorService executor = Executors.newFixedThreadPool(1);
		SimpleTimeLimiter tl = new SimpleTimeLimiter(executor);
		// 实例化测试类
		TimeEasy tb = new TimeBreak();
		// 通过代理委托
		TimeEasy proxy = tl.newProxy(tb, TimeEasy.class, 2, TimeUnit.SECONDS);

		try {
			proxy.test();
			System.out.println("正常结束");
		} catch (Exception ex) {

			System.out.println("超时结束");

		} finally {

			executor.shutdown();
		}
	}

	/**
	 * 测试基于回调的方式
	 */
	public static void testCallTimeOut() {

		ExecutorService executor = Executors.newFixedThreadPool(1);
		SimpleTimeLimiter stl = new SimpleTimeLimiter(executor);
		String result = null;
		try {

			result = stl.callWithTimeout(new Callable<String>() {

				@Override
				public String call() throws Exception {

					// 逻辑实现
					Thread.sleep(6 * 1000);
					return "hadoop+spark";

				}

			},

					5, TimeUnit.SECONDS, true);
			System.out.println("正常调用:" + result);

		} catch (Exception e) {
			System.out.println("超时调用：" + result);
		} finally {

			// 销毁资源池
			executor.shutdown();
		}

	}

}
