package com.hashedin;
//user id | age | gender | occupation | zip code
public class User {
	int userID;
	int age;
	String gender;
	String occupation;
	String zip; ;
	int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count += count;
	}
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", age=" + age + ", gender=" + gender
				+ ", occupation=" + occupation + ", zip=" + zip + ", count="
				+ count + "]";
	}
	
	
	
	

}
