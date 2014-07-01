package com.hashedin;

public class ratings {
	int userId;
	int itemId;
	int ratings;
	int timestap;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public int getTimestap() {
		return timestap;
	}
	public void setTimestap(int timestap) {
		this.timestap = timestap;
	}
	@Override
	public String toString() {
		return "ratings [userId=" + userId + ", itemId=" + itemId
				+ ", ratings=" + ratings + ", timestap=" + timestap + "]";
	}
	
	
}