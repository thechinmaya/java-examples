package com.sahu.chinmaya.misc;

import java.util.LinkedList;

public class ProducerConsumerClassic {
	
	public static void main(String[] args) throws InterruptedException {
		
		ProdConc prodConc =new ProdConc();
		
		Thread t1 = new Thread(() -> {
			try {
				prodConc.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() ->  {
			try {
				prodConc.consume();
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

class ProdConc {
	LinkedList<Integer> buffer = new LinkedList<>();
	int capacity=1;
	
	public void produce() throws InterruptedException
	{
		int value=0;
		
		while(true)
		{
			synchronized (this) {
				if(buffer.size() >= capacity)
					wait();
				buffer.add(value++);
				System.out.println("Procuded "+buffer);
				notify();
				
				Thread.sleep(1000L);
			}
			
		}
		
	}
	
	public void consume() throws InterruptedException
	{
		while(true) {
			
			synchronized (this) {
				if(buffer.size() == 0)
					wait();
				System.out.println("Consumed "+ buffer.removeFirst());
				notify();
				
				//Thread.sleep(1000L);	
			}
			
			
		}
		
	}
}
