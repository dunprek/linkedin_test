package com.don.linkedin_test.model;

import com.google.gson.annotations.SerializedName;

public class Person{

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("emailAddress")
	private String emailAddress;

	@SerializedName("pictureUrl")
	private String pictureUrl;

	@SerializedName("id")
	private String id;

	public String getFirstName(){
		return firstName;
	}

	public String getEmailAddress(){
		return emailAddress;
	}

	public String getPictureUrl(){
		return pictureUrl;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Person{" + 
			"firstName = '" + firstName + '\'' + 
			",emailAddress = '" + emailAddress + '\'' + 
			",pictureUrl = '" + pictureUrl + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}