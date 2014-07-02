package com.hashedin;

public class ratings {
	int userId;
	 int itemId;
	int ratings;
	int timestamp;
	
	
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
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int Timestamp) {
		this.timestamp = Timestamp;
	}
	@Override
	public String toString() {
		return "ratings [userId=" + userId + ", itemId=" + itemId
				+ ", ratings=" + ratings + ", Timestamp=" + timestamp + "]";
	}
	
	
}