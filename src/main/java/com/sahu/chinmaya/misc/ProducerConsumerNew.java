package com.sahu.chinmaya.misc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerNew {
	
	public static void main(String[] args) throws InterruptedException {
		
		ProdConc2 prodConc2 = new ProdConc2();
		
		Thread t1 = new Thread(() -> {
			try {
				prodConc2.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				prodConc2.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		
		//t1.join();
		//t2.join();
		
	}

}


class ProdConc2 {
	
	BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(5);
	
	public void produce() throws InterruptedException
	{
		int value=0;
		
		while(true)
		{
			buffer.put(value++);
			System.out.println("Producer " + buffer);
			Thread.sleep(1000L);
			
		}
		
	}
	
	public void consume() throws InterruptedException
	{
		while(true) {
			System.out.println("Receiver "+buffer.take());
			Thread.sleep(1000L);
		}
		
	}
}
