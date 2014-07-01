package com.hashedin;

import java.util.List;
import java.io.IOException;
import java.io.InputStream;
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
	 			

	 			public Map<String, ratings> getRate(InputStream movieStream)
					throws IOException {

				Map<String, ratings> rateMap = new HashMap<>();
				List <String> lines = IOUtils.readLines(movieStream);

				for (String line : lines) {
					 ratings rate = parseRate(line);
					rateMap.put(Integer.toString(rate.getUserId()), rate);
					System.out.println(rate);
				}
				return rateMap;
	}					

	 			ratings parseRate(String movieRecord) {
					StringTokenizer token = new StringTokenizer(movieRecord, "	");
					ratings m = new ratings();
					m.setUserId(Integer.parseInt(token.nextToken()));
					m.setItemId(Integer.parseInt(token.nextToken()));
					m.setRatings(Integer.parseInt(token.nextToken()));
					m.setTimestap(Integer.parseInt(token.nextToken()));
					return (m);
				}


			public static void main(String[] args) throws IOException {
				MovieManager m = new MovieManager();
				Map<String, Movie> movieMap = m.getMovies(m.getClass().getClassLoader().getResourceAsStream("movie.data"));
				MovieManager rate = new MovieManager();
				Map<String, ratings> rateMap = rate.getRate(rate.getClass().getClassLoader().getResourceAsStream("ratings.data"));
			}
		 		
		
}
