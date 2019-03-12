package com.sahu.chinmaya.designp;

import org.junit.Assert;
import org.junit.Test;

public class PerfectSingletonTest {

	@Test
	public void testSingleTon()
	{
		PerfectSingleton perfectSingleton = PerfectSingleton.getInstance();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PerfectSingleton perfectSingleton2 = PerfectSingleton.getInstance();
		Assert.assertEquals("Equal",perfectSingleton.getName(), perfectSingleton2.getName());
		
	}
}
