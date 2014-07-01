package com.hashedin;

import java.util.Arrays;

public class Movie {
	int movie_id;
	String movie_name;
	String release_date;
	String video_release_date;
	String url;
	int[] genre;
	private int rating;
	
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
	public void setUrl(String url) {
		this.url = url;
	}
	public int[] getGenre() {
		return genre;
	}
	public void setGenre(int[] genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", movie_name=" + movie_name
				+ ", release_date=" + release_date + ", video_release_date="
				+ video_release_date + ", url=" + url + ", genre="
				+ Arrays.toString(genre) + "]";
	}
	
	
	
}
