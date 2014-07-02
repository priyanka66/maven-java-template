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
					ArrayList<String>genre = new ArrayList<>();
					m.setMovie_id(Integer.parseInt(token.nextToken()));
					m.setMovie_name(token.nextToken());
					m.setRelease_date(token.nextToken());
					m.setUrl(token.nextToken());
					int count =0;
					while(token.hasMoreElements())
					{
						int tempGenre = Integer.parseInt(token.nextToken());
						if(tempGenre ==1 && count<19){
							switch(count) {
							case 0 :  genre.add("unknown");
								   	  break;
							case 1 :  genre.add("action");
						   	  break;
							case 2 :  genre.add("adventure");
						   	  break;
							case 3 :  genre.add("animation");
						   	  break;
							case 4 :  genre.add("children's");
						   	  break;
							case 5 :  genre.add("comedy");
						   	  break;
							case 6 :  genre.add("crime");
						   	  break;
							case 7 :  genre.add("documentary");
						   	  break;
							case 8 :  genre.add("drama");
						   	  break;
						   	  case 9 :  genre.add("fantasy");
						   	  break;
						   	case 10 :  genre.add("film-noir");
						   	  break;
						   	case 11 :  genre.add("horror");
						   	  break;
						   	case 12 :  genre.add("musical");
						   	  break;
						   	case 13 :  genre.add("romance");
						   	  break;
						   	case 14 :  genre.add("sci-fi");
						   	  break;
						   	case 15 :  genre.add("thriller");
						   	  break;
						   	case 16 :  genre.add("war");
						   	  break;
						   	case 17 :  genre.add("western");
						   	  break;
						   	case 18 :  genre.add("unknown");
						   	  break;
						   	  default : 
							}
						}
						count++;
					}
					m.setGenre(genre);
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
				 System.out.println(movieMap.get(1).getGenre());
				
				 MovieFreak Freak = new MovieFreak(movieMap, rateMap, usrMap);				 		
		        // System.out.println("Most Watched movie is :");
		         Freak.MostWatchedMovie(movieMap,rateMap,usrMap);
		         Freak.mostActiveuser(movieMap, rateMap, usrMap);
		        Movie higestRated= Freak.highestRatedGenre(movieMap,rateMap,usrMap);
		        System.out.println("The highest rated movie is : ");
		        System.out.println(higestRated.getMovie_name());
		      //  System.out.println(higestRated.getAvg());
			}

			
				
			}
