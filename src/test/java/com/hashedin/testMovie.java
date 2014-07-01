package com.hashedin;

import java.io.IOException;
import java.util.Map;

import junit.framework.TestCase;

public class testMovie extends TestCase{
	
	public static void main(String[] args) throws IOException {
		MovieManager m = new MovieManager();
		Map<String, Movie> movieMap = m.getMovies(m.getClass().getClassLoader().getResourceAsStream("testmovie.data"));
	   assertEquals(movieMap.size(), "3");
	}

		
}
