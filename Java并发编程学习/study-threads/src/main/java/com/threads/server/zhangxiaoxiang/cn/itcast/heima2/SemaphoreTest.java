package com.threads.server.zhangxiaoxiang.cn.itcast.heima2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore可以维护当前访问自身的线程个数,并提供了同步机制。使用 Semaphore可以控制同时访问资源的线程个数,
 * 例如,实现一个文件允许的并发访问Semaphore实现的功能就类似厕所有5个坑,假如有十个人要上厕所,那么同时能有多少个人去上厕所呢?
 * 同时只能有5个人能够占用,当5个人中的任何一个人让开后,其中在等待的另外5个人中又有一个可以占用了。
 * 另外等待的5个人中可以是随机获得优先机会,也可以是按照先来后到的顺序获得杌会,这取决于构造 Semaphore对象时传入的参数选项
 * 单个信号量的 Semaphore对象可以实现互斥锁的功能,并且可以是程获得了“锁”,再由另一个线程释放“锁”,这可应用于死锁恢复的一些场合。
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Semaphore sp = new Semaphore(3);
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						sp.acquire();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.out.println("线程" + Thread.currentThread().getName() + "进入,当前已有" + (3 - sp.availablePermits()) + "并发");
					try {
						Thread.sleep((long) (Math.random() * 10000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("线程" + Thread.currentThread().getName() + "即将离开");
					sp.release();
					//下面的代码有时候执行不准,因为没有和上面的代码合成原子
					System.out.println("线程" + Thread.currentThread().getName() + "已经离开,当前已有" + (3 - sp.availablePermits()) + "并发");
				}
			};
			service.execute(runnable);
		}
	}

}
