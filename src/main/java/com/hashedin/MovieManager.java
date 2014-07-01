package com.hashedin;

import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

//import org.omg.CORBA.portable.InputStream;

public class MovieManager {
				
	 			public Map<String, Movie> getMovies(InputStream movieStream)
					throws IOException {

				Map<String, Movie> movieMap = new HashMap<>();
				List <String> lines = IOUtils.readLines(movieStream);

				for (String line : lines) {
					Movie m = parseMovie(line);
					movieMap.put(Integer.toString(m.getMovie_id()), m);
					System.out.println(m);
				}
				return movieMap;
	}					

	 			Movie parseMovie(String movieRecord) {
					StringTokenizer token = new StringTokenizer(movieRecord, "|");
					Movie m = new Movie();
					m.setMovie_id(Integer.parseInt(token.nextToken()));
					m.setMovie_name(token.nextToken());
					m.setRelease_date(token.nextToken());
					m.setUrl(token.nextToken());
					return (m);
				}
	 			

	 			public ArrayList<ratings> getRate(InputStream movieStream)
					throws IOException {

				ArrayList<ratings> rateMap = new ArrayList<ratings>();
				List <String> lines = IOUtils.readLines(movieStream);

				for (String line : lines) {
					 ratings rate = parseRate(line);
					rateMap.add(rate);
					System.out.println(rate);
				}
				return rateMap;
	}					

	 			ratings parseRate(String movieRecord) {
					StringTokenizer token = new StringTokenizer(movieRecord, "	");
					ratings rate = new ratings();
					rate.setUserId(Integer.parseInt(token.nextToken()));
					rate.setItemId(Integer.parseInt(token.nextToken()));
					rate.setRatings(Integer.parseInt(token.nextToken()));
					rate.setTimestap(Integer.parseInt(token.nextToken()));
					return (rate);
				}
	 			
	 			public Map<String, User> getUsr(InputStream movieStream)
						throws IOException {

					Map<String, User> usrMap = new HashMap<>();
					List <String> lines = IOUtils.readLines(movieStream);

					for (String line : lines) {
						 User usr = parseUsr(line);
						usrMap.put(Integer.toString(usr.getUserID()), usr);
						System.out.println(usr);
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
				Map<String, Movie> movieMap = m.getMovies(m.getClass().getClassLoader().getResourceAsStream("movie.data"));
				MovieManager rate = new MovieManager();
				ArrayList<ratings> rateMap = rate.getRate(rate.getClass().getClassLoader().getResourceAsStream("ratings.data"));
				MovieManager usr = new MovieManager();
				Map<String, User> usrMap = usr.getUsr(usr.getClass().getClassLoader().getResourceAsStream("user.data"));
				
			
			}
			
			
		 		
		
}
