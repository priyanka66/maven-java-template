package com.hashedin;

import java.util.ArrayList;
import java.util.Arrays;

public class Movie {
	int movie_id;
	String movie_name;
	String release_date;
	String video_release_date;
	String url;
	ArrayList<String>genre = new ArrayList<>();
	int totalRatings;
	int totalUserCount; 
	float avg;
	
	public float getAvg() {
		return avg;
	}
	
	public int getCurrentRatings() {
		return currentRatings;
	}
	public void setCurrentRatings(int currentRatings) {
		this.currentRatings = currentRatings;
	}
	public void setGenre(ArrayList<String> genre) {
		this.genre = genre;
		
	}
	
	public ArrayList<String> getGenre() {
		return genre;
	}
	public int getTotalUserCount() {
		return totalUserCount;
	}
	public void setTotalUserCount(int totalUserCount) {
		this.totalUserCount += totalUserCount;
	}
	private int rating;
	private int currentRatings;
	
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int i) {
		this.movie_id = i;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getUrl() {
		return url;
	}
	public String getVideo_release_date() {
		return video_release_date;
	}
	public void setVideo_release_date(String video_release_date) {
		this.video_release_date = video_release_date;
	}
	public int getTotalRatings() {
		return totalRatings;
	}
	public void setTotalRatings(int currentRatings) {
			totalRatings=totalRatings+currentRatings;
	}
	
	public void updateRating(){
		
		
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", movie_name=" + movie_name
				+ ", release_date=" + release_date + ", video_release_date="
				+ video_release_date + ", url=" + url + ", genre="
				 + ", totalRatings=" + totalRatings
				+ ", totalUserCount=" + totalUserCount + ", rating=" + rating
				+ "]";
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}
	
	
	
}
