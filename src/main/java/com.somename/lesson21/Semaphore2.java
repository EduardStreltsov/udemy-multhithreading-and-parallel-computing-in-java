package com.somename.lesson21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Semaphore2 {
	
	INSTANCE;
	
	private Semaphore semaphore = new Semaphore(5, true);
	
	public void downloadData() {
		try {
			semaphore.acquire();
			download();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
	
	private void download() {
		System.out.println("download");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 12; i++) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					Semaphore2.INSTANCE.downloadData();
				}
			});
		}
	}
	
}
