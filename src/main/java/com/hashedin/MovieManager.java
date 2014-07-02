package com.hashedin;

import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

import java.util.*;

//import org.omg.CORBA.portable.InputStream;

public class MovieManager {
				
	 			public Map<Integer, Movie> getMovies(InputStream movieStream)
					throws IOException {

				Map<Integer, Movie> movieMap = new HashMap<>();
				List <String> lines = IOUtils.readLines(movieStream);

				for (String line : lines) {
					Movie m = parseMovie(line);
					movieMap.put(m.getMovie_id(), m);
				//	System.out.println(m);
				}
				
			//	System.out.println(movieMap);
				
				return movieMap;
	}					

	 			Movie parseMovie(String movieRecord) {
					StringTokenizer token = new StringTokenizer(movieRecord, "|");
					Movie m = new Movie();
					m.setMovie_id(Integer.parseInt(token.nextToken()));
					m.setMovie_name(token.nextToken());
					m.setRelease_date(token.nextToken());
					m.setUrl(token.nextToken());
				//	m.setGenre(Integer.parseInt(token.nextToken()));
					return (m);
				}
	 			

	 			public ArrayList<ratings> getRate(InputStream movieStream)
					throws IOException {

				ArrayList<ratings> rateMap = new ArrayList<ratings>();
				List <String> lines = IOUtils.readLines(movieStream);

				for (String line : lines) {
					 ratings rate = parseRate(line);
					rateMap.add(rate);
					//System.out.println(rate);
				}
				
				//System.out.println(rateMap.get(1));
				return rateMap;
				
	}					

	 			ratings parseRate(String movieRecord) {
					StringTokenizer token = new StringTokenizer(movieRecord, "	");
					ratings rate = new ratings();
					rate.setUserId(Integer.parseInt(token.nextToken()));
					rate.setItemId(Integer.parseInt(token.nextToken()));
					rate.setRatings(Integer.parseInt(token.nextToken()));
					rate.setTimestamp(Integer.parseInt(token.nextToken()));
					return (rate);
				}
	 			
	 			public Map<Integer, User> getUsr(InputStream movieStream)
						throws IOException {

					Map<Integer, User> usrMap = new HashMap<>();
					List <String> lines = IOUtils.readLines(movieStream);

					for (String line : lines) {
						 User usr = parseUsr(line);
						usrMap.put((usr.getUserID()), usr);
					//	System.out.println(usr);
					}
					return usrMap;
		}					

		 			User parseUsr(String movieRecord) {
						StringTokenizer token = new StringTokenizer(movieRecord, "|");
						User usr = new User();
						usr.setUserID(Integer.parseInt(token.nextToken()));
						usr.setAge(Integer.parseInt(token.nextToken()));
						usr.setGender(token.nextToken());
						usr.setOccupation(token.nextToken());
						usr.setZip((token.nextToken()));
						return (usr);
					}


			public static void main(String[] args) throws IOException {
				MovieManager m = new MovieManager();
				Map<Integer, Movie> movieMap = m.getMovies(m.getClass().getClassLoader().getResourceAsStream("movie.data"));
				MovieManager rate = new MovieManager();
				ArrayList<ratings> rateMap = rate.getRate(rate.getClass().getClassLoader().getResourceAsStream("ratings.data"));
				MovieManager usr = new MovieManager();
				
				Map<Integer, User> usrMap = usr.getUsr(usr.getClass().getClassLoader().getResourceAsStream("user.data"));
				
				 for(ratings ratingObj :rateMap ) {
				   Movie movieObj = movieMap.get(ratingObj.getItemId());
				   movieObj.setTotalUserCount(1);
				   movieObj.setTotalRatings(ratingObj.getRatings());
			 // System.out.println(movieObj.getTotalUserCount());
			 // System.out.println(movieObj.getTotalRatings());
				// System.out.println(movieObj);
				 User userObj = usrMap.get(ratingObj.getUserId());
				 userObj.setCount(1);
				// System.out.println(userObj);
				 }
				 
				// System.out.println("--------------------------------");
				// System.out.println(movieMap);
				
				 MovieFreak Freak = new MovieFreak(movieMap, rateMap, usrMap);				 		
		        // System.out.println("Most Watched movie is :");
		         Freak.MostWatchedMovie(movieMap,rateMap,usrMap);
		         Freak.mostActiveuser(movieMap, rateMap, usrMap);
}

			
				
			}
