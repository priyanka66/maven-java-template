package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import junit.framework.TestCase;

public class testMovie extends TestCase{
	
	public void test() throws IOException{
		MovieManager m = new MovieManager();
		InputStream movieStream = m.getClass().getClassLoader().getResourceAsStream("testmovie.data");
		Map<String, Movie> movieMap = m.getMovies(movieStream);
	   assertEquals(movieMap.size(), 3);
	  
	   //	   assertEquals( movieMap.get(3).getMovie_name(),"Four Rooms (1995)" );
	}

		
}
