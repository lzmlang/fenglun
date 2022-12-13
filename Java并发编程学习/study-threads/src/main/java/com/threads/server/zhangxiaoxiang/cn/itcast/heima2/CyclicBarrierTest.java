package com.threads.server.zhangxiaoxiang.cn.itcast.heima2;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 表示大家彼此家集合好后才开始出发,分散活动后又在指定地点集合碰司集合后,冉同时出发到周在足集咨后同并是金毫出发到公
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final CyclicBarrier cb = new CyclicBarrier(3);
		for (int i = 0; i < 3; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						Thread.sleep((long) (Math.random() * 10000));
						System.out.println("线程" + Thread.currentThread().getName() +
								"已经到达集合点1,当前已有" + (cb.getNumberWaiting() + 1) + "已经到达" + (cb.getNumberWaiting() == 2 ? "都到齐了,往下个集合点继续走" : "正在等候"));
						cb.await();

						Thread.sleep((long) (Math.random() * 10000));
						System.out.println("线程" + Thread.currentThread().getName() +
								"已经到达集合点2,当前已有" + (cb.getNumberWaiting() + 1) + "已经到达" + (cb.getNumberWaiting() == 2 ? "都到齐了,往下个集合点继续走" : "正在等候"));
						cb.await();
						Thread.sleep((long) (Math.random() * 10000));
						System.out.println("线程" + Thread.currentThread().getName() +
								"已经到达集合点3,当前已有" + (cb.getNumberWaiting() + 1) + "已经到达" + (cb.getNumberWaiting() == 2 ? "都到齐了,往下个集合点继续走" : "正在等候"));
						cb.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			service.execute(runnable);
		}
		service.shutdown();
	}
}
