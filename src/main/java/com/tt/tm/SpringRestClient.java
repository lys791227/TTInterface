package com.tt.tm;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tt.tm.bean.UserInfo;



public class SpringRestClient {
	
	public static final String SERVER_URI = "http://localhost:8080/";
	public static void main(String[] args) {

		//getAllUser();
		//addUser();

	}

	private static void addUser() {
		
		RestTemplate restTemplate = new RestTemplate();
		UserInfo userinfo=new UserInfo();
		userinfo.setName("刘尧枢");
		userinfo.setPwd("88888");
		userinfo.setState(1);
		String body=restTemplate.postForObject(SERVER_URI+"addUser",userinfo,String.class);
		ObjectMapper mapper = new ObjectMapper();
     	//List<LinkedHashMap<String,String>> userinfo_list = null;
		UserInfo userinfo1=new UserInfo();
     	try {
     		userinfo1 = mapper.readValue(body, UserInfo.class);
         } catch (JsonParseException e) {
             e.printStackTrace();
         } catch (JsonMappingException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
		System.out.println(userinfo1);
		
		
	}

	@SuppressWarnings("unchecked")
	private static void getAllUser() {

		
		RestTemplate restTemplate = new RestTemplate();
		String body=restTemplate.postForObject(SERVER_URI+"getAllUser", null,String.class);
		ObjectMapper mapper = new ObjectMapper();
     	List<LinkedHashMap<String,String>> userinfo_list = null;
     	
     	try {
     		userinfo_list = mapper.readValue(body,  List.class);
         } catch (JsonParseException e) {
             e.printStackTrace();
         } catch (JsonMappingException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
		
		for(LinkedHashMap<String,String> user:userinfo_list){			
			System.out.println(user);
			
		}
  		
  		
		
	}

}
