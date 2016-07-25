package com.tt.tm;

import java.io.IOException;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tt.tm.bean.UserInfo;

public class HttpClientDemo {

	public static void main(String[] args) {
		// HttpGetTest();
		//HttpPostTest();
		
	
	}
	
	@Test
	public  void HttpPostTest() {

		try {
			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpPost httpPost = new HttpPost("http://localhost:8080/updateUser");
			httpPost.addHeader("content-type", "application/json");
			httpPost.addHeader("Accept", "application/json");
			UserInfo userinfo = new UserInfo();
			userinfo.setId(15);
			userinfo.setName("http-client-update");
			userinfo.setPwd("7912");
			userinfo.setState(2);
			Gson gson = new Gson();
			String jsonString = gson.toJson(userinfo);
			StringEntity entity = new StringEntity(jsonString);
			httpPost.setEntity(entity);

			HttpResponse httpResponse = httpClient.execute(httpPost);
			String response = EntityUtils.toString(httpResponse.getEntity());
			System.out.println(response);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}

	@Test
	public  void HttpGetTest() {

		HttpClient httpClient = HttpClientBuilder.create().build();

		HttpPost request = new HttpPost("http://localhost:8080/getAllUser");
		request.addHeader("content-type", "application/json");
		request.addHeader("Accept", "application/json");
		try {

			HttpResponse httpResponse = httpClient.execute(request);
			String response = EntityUtils.toString(httpResponse.getEntity());

			Gson gson = new Gson();
			List<UserInfo> embossList = gson.fromJson(response, new TypeToken<List<UserInfo>>() {
			}.getType());

			for (UserInfo userinfo : embossList) {

				System.out.println(userinfo);

			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

}
