package com.somename.lesson008;

class StartingThreadsWithRunnable {
	
	public static void main(String[] args) {
		new Thread(new Runner1()).start();
		new Thread(new Runner2()).start();
	}
}
