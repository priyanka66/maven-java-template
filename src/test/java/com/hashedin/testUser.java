package com.hashedin;

import java.io.IOException;
import java.util.Map;

import junit.framework.TestCase;

public class testUser extends TestCase{
	
	public void test() throws IOException{
		MovieManager usr = new MovieManager();

		Map<String, User> usrMap = usr.getUsr(usr.getClass().getClassLoader().getResourceAsStream("user.data"));
		assertEquals(usrMap.size(), 3);
		
	}

		
}
