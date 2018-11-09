package com.somename.lesson015;

import java.util.ArrayList;
import java.util.List;

public class WaitAndNotify {
	
	private List<Integer> list = new ArrayList<>();
	private static final int LIMIT = 5;
	private static final int BOTTOM = 0;
	private final Object lock = new Object();
	private int value = 0;
	
	public void produce() throws InterruptedException {
		synchronized (lock) {
			while (true) {
				if (list.size() == LIMIT) {
					System.out.println("produce. waiting for remove");
					lock.wait();
				} else {
					System.out.println("produce. adding " + value);
					list.add(value);
					value++;
					lock.notify();
				}
				Thread.sleep(500);
			}
		}
	}
	
	public void consume() throws InterruptedException {
		Thread.sleep(1000);
		
		synchronized (lock) {
			
			while (true) {
				if (list.size() == BOTTOM) {
					System.out.println("consume. waiting for adding");
					lock.wait();
				} else {
					System.out.println("consume. removed " + list.remove(--value));
					lock.notify();
				}
				Thread.sleep(500);
			}
		}
	}
	
	public static void main(String[] args) {
		
		WaitAndNotify waitAndNotify = new WaitAndNotify();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					waitAndNotify.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					waitAndNotify.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("finish");
	}
}
