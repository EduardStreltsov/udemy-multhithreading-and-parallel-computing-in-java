package com.somename.lesson014;

public class SynchronizedBlocks {
	
	private static int counter1 = 0;
	private static int counter2 = 0;
	
	private static Object l1 = new Object();
	private static Object l2 = new Object();
	
	public static void increment1() {
		synchronized (l1) {
			counter1++;
		}
	}
	
	public static void increment2() {
		synchronized (l2) {
			counter2++;
		}
	}
	
	public static void compute() {
		for (int i = 0; i < 10000; i++) {
			increment1();
			increment2();
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				compute();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				compute();
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
		
		System.out.println("Counter1 " + counter1);
		System.out.println("Counter2 " + counter2);
	}
}
