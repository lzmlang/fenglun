package com.threads.server.zhangxiaoxiang.cn.itcast.heima2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 子线程循环10次,接着主线程循环100,接着又回到子线程循环10次,接着再回到主线程又循环100,如此循环50次,请写出程序
 */
public class ConditionCommunication {

	public static void main(String[] args) {

		final Business business = new Business();
		new Thread(
				new Runnable() {

					@Override
					public void run() {

						for (int i = 1; i <= 50; i++) {
							business.sub(i);
						}

					}
				}
		).start();

		for (int i = 1; i <= 50; i++) {
			business.main(i);
		}

	}

	static class Business {
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		private boolean bShouldSub = true;

		public void sub(int i) {
			lock.lock();
			try {
				while (!bShouldSub) {
					try {
						condition.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for (int j = 1; j <= 10; j++) {
					System.out.println("sub thread sequence of " + j + ",loop of " + i);
				}
				bShouldSub = false;
				condition.signal();
			} finally {
				lock.unlock();
			}
		}

		public void main(int i) {
			lock.lock();
			try {
				while (bShouldSub) {
					try {
						condition.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for (int j = 1; j <= 100; j++) {
					System.out.println("main thread sequence of " + j + ",loop of " + i);
				}
				bShouldSub = true;
				condition.signal();
			} finally {
				lock.unlock();
			}
		}

	}
}
