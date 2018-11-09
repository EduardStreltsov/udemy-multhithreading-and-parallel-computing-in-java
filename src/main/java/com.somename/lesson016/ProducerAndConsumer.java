package com.somename.lesson016;

public class ProducerAndConsumer {
	
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("produce");
			wait();
			System.out.println("produce again");
		}
	}
	
	public void consume() throws InterruptedException {
		Thread.sleep(1000);
		
		synchronized (this) {
			System.out.println("consume");
			notify();
			Thread.sleep(3000);
			System.out.println("consume again");
		}
	}
	
	public static void main(String[] args) {
		
		ProducerAndConsumer waitAndNotify = new ProducerAndConsumer();
		
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
				
				//	assWawingJustForFun();
	}
	
	private static void assWawingJustForFun() {
		int step = 0;
		for (int i = 0; i < 1000; i++) {
			switch (step) {
				case 0:
					System.out.println("( \\ )");
					break;
				case 1:
					System.out.println("( | )");
					break;
				case 2:
					System.out.println("( / )");
					break;
				case 3:
					System.out.println("( | )");
					break;
			}
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			step++;
			if (step > 3) step = 0;
		}
	}
	
}
