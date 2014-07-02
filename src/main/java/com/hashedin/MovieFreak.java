package com.hashedin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MovieFreak {

	public MovieFreak(Map<Integer, Movie> movieMap, ArrayList<ratings> rateList,
			Map<Integer, User> usrMap) {
		
		List<Movie> movieList = new ArrayList<Movie>(movieMap.values());
		List<User>userList = new ArrayList<User>(usrMap.values());
		//System.out.println(movieList);
		
	}

	
	   public Movie MostWatchedMovie(Map<Integer, Movie> movieMap, ArrayList<ratings> rateMap, Map<Integer, User> usrMap) 
	   {
		
		   List<Movie> movieList = new ArrayList<Movie>(movieMap.values());
			List<User>userList = new ArrayList<User>(usrMap.values());
		
			 Movie mostWatched = new Movie();
			 mostWatched = Collections.max(movieList, new Comparator<Movie>() {

			 public int compare(Movie o1, Movie o2) {
				 	return Integer.compare(o1.getTotalUserCount(),o2.getTotalUserCount());
			 				}	
			 });
			 System.out.println("mostWatchedMovie:"+mostWatched.getMovie_name());

			 return mostWatched;
			 }


	   	public User mostActiveuser(Map<Integer, Movie> movieMap, ArrayList<ratings> rateMap, Map<Integer, User> usrMap) {
	   		List<Movie> movieList = new ArrayList<Movie>(movieMap.values());
			List<User>userList = new ArrayList<User>(usrMap.values());
	   		User u1 = new User();
	   		u1 = Collections.max(userList, new Comparator<User>() {
	   			public int compare(User o1, User o2) {
	   				return Integer.compare(o1.getCount(), o2.getCount());

	   				}
	   				});

	   				System.out.println("mostActiveuser:"+u1.getUserID());
	   					return u1;
}

}