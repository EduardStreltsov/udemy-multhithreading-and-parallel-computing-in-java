package com.somename.lesson011;

public class Worker implements Runnable {
	
	private boolean isTerminated = false;
	
	@Override
	public void run() {
		while (!isTerminated) {
			System.out.println("Worker");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isTerminated() {
		return isTerminated;
	}
	
	public void setTerminated(boolean terminated) {
		isTerminated = terminated;
	}
}
