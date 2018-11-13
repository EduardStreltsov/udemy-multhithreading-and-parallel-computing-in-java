package com.somename.lesson017;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
	
	private static int counter = 0;
	private static Lock lock = new ReentrantLock();
	
	public static void increment() {
		
		lock.lock();
		
		for (int i = 0; i < 10000; i++) {
			counter++;
			throw new RuntimeException();
		}
		
		lock.unlock();
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					increment();
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					increment();
				} catch (RuntimeException e) {
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
		
		System.out.println("counter: " + counter);
	}
	
}
