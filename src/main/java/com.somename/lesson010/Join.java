package com.somename.lesson010;

import com.somename.lesson008.Runner1;
import com.somename.lesson008.Runner2;

public class Join {
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner1());
		Thread t2 = new Thread(new Runner2());
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main thread");
	}
	
}
