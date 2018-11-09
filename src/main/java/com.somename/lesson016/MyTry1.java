package com.somename.lesson016;

// wagging ass
public class MyTry1 {
	
	private boolean toTheLeft;
	
	private void toTheLeft() {
		synchronized (this) {
			while (true) {
				if (toTheLeft);
			}
		}
	}
	
	private void toTheRight() {
		synchronized (this){
		
		}
	}
	
	public static void main(String[] args) {
		
		MyTry1 process = new MyTry1();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				process.toTheLeft();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				process.toTheRight();
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
