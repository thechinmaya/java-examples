package com.sahu.chinmaya.designp;

import java.io.Serializable;

public class PerfectSingleton implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public String getName() {
		return name;
	}
	
	private PerfectSingleton()
	{
		System.out.println("initialized now");
		this.name="initialized once - "+System.currentTimeMillis();
	}
	
	private static class ObjectHolder{
		private static final PerfectSingleton INSTANCE= new PerfectSingleton();
	}
	
	public static PerfectSingleton getInstance()
	{
		return ObjectHolder.INSTANCE;
	}
	
	protected Object readResolve()
	{
		return getInstance();
	}

}
