package com.qa.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_Post_Call_Request 
{
	@Test
	public void postRequestTest()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("first_name", "abcde");
		jsonobject.put("job", "QA");
		jsonobject.put("email", "test123@gmail.com");
		
		httprequest.body(jsonobject.toJSONString());
		
		Response response=httprequest.post();
		System.out.println(response.getBody().asString());
		
		int stastuscode=response.getStatusCode();
		System.out.println(stastuscode);
		
		String statusline=response.getStatusLine();
		System.out.println(statusline);
	}

}
