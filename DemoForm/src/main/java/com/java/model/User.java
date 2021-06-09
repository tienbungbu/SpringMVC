package com.java.model;

import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class User {
	@NotEmpty
	private String name;
	@NotEmpty 
	private String username;
	@NotEmpty @Length(min = 6 , max =  12)
	private String password;
	private int id;
	private String gender;
	private List<String> favourites;
	private String about;
	private boolean acceptAgreement;
	private MultipartFile avatar;
	
	
	
	public MultipartFile getAvatar() {
		return avatar;
	}
	public void setAvatar(MultipartFile avatar) {
		this.avatar = avatar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public boolean isAcceptAgreement() {
		return acceptAgreement;
	}
	public void setAcceptAgreement(boolean acceptAgreement) {
		this.acceptAgreement = acceptAgreement;
	}
	public List<String> getFavourites() {
		return favourites;
	}
	public void setFavourites(List<String> favourites) {
		this.favourites = favourites;
	}
	
	
}
