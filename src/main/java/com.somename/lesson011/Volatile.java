package com.somename.lesson011;

public class Volatile {
	
	public static void main(String[] args) {
		
		Worker worker = new Worker();
		Thread t1 = new Thread(worker);
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		worker.setTerminated(true);
		System.out.println("Finished");
	}
	
}
