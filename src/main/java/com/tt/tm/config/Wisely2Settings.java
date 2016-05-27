package com.tt.tm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@ConfigurationProperties(prefix = "wisely2")
@ConfigurationProperties(prefix = "wisely",locations = "classpath:config/wisely.properties")  
public class Wisely2Settings {
	private String name;
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}