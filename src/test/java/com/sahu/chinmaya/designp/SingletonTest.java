package com.sahu.chinmaya.designp;

import org.junit.Assert;
import org.junit.Test;

public class SingletonTest {

	@Test
	public void testSingleTon()
	{
		PerfectSingleton perfectSingleton = PerfectSingleton.getInstance();
		PerfectSingleton perfectSingleton2 = PerfectSingleton.getInstance();
		Assert.assertEquals("Equal",perfectSingleton.getName(), perfectSingleton2.getName());
		
	}
}
