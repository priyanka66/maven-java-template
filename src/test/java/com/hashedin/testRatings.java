package com.hashedin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import junit.framework.TestCase;

public class testRatings extends TestCase{
	
	public void test() throws IOException{
		MovieManager rate = new MovieManager();
		ArrayList<ratings> rateMap = rate.getRate(rate.getClass().getClassLoader().getResourceAsStream("ratings.data"));
	   assertEquals(rateMap.size(), 3);
	}

		
}
