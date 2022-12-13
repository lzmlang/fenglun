package com.threads.server.zhangxiaoxiang.cn.itcast.heima2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 犹如倒计旷计数器,调用 Countdownlatch对象的 countdown方法就将计数器减1,当计数到达0时,则所有等待看或个等待者廾始执行。
 * 这直接通过代码米说明 Countdownlatch的作用,这样学员的理解效果更直接。
 */
public class CountdownLatchTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final CountDownLatch cdOrder = new CountDownLatch(1);
		final CountDownLatch cdAnswer = new CountDownLatch(3);
		for (int i = 0; i < 3; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						System.out.println("线程-" + Thread.currentThread().getName() + "准备接受命令");
						cdOrder.await();
						System.out.println("线程-" + Thread.currentThread().getName() + "已经接受命令");
						Thread.sleep((long) (Math.random() * 10000));
						System.out.println("线程-" + Thread.currentThread().getName() + "回应命令处理结果");
						cdAnswer.countDown();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			service.execute(runnable);
		}
		try {
			Thread.sleep((long) (Math.random() * 10000));
			System.out.println("线程-" + Thread.currentThread().getName() + "即将发布命令");
			cdOrder.countDown();
			System.out.println("线程-" + Thread.currentThread().getName() + "已经发送命令,等待结果");
			cdAnswer.await();
			System.out.println("线程-" + Thread.currentThread().getName() + "已经收到所有响应");
		} catch (Exception e) {
			e.printStackTrace();
		}
		service.shutdown();

	}
}
