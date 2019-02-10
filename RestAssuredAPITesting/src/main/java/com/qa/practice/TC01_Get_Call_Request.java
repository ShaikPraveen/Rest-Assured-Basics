package com.qa.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_Get_Call_Request
{
	@Test
	public void getRequestTest()
	{
		//Define base uri
		RestAssured.baseURI="https://reqres.in/api/users";
		//define request
		RequestSpecification httprequest=RestAssured.given();
		//Execute request
		Response response=httprequest.request(Method.GET, "/4");
		String responsebody=response.getBody().asString();
		System.out.println("RESPONSE BODY IS "+responsebody);
		
		Assert.assertEquals(responsebody.contains("Eve"), true);
		
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		
		String statusline=response.getStatusLine();
		System.out.println(statusline);
		
		 Headers headers=response.getHeaders();
		 System.out.println(headers);
		 
		 String connection=response.getHeader("Connection");
		 System.out.println(connection);
		 
		JsonPath path= response.jsonPath();
		String firstname=path.get("first_name");
		System.out.println(firstname);
		
		String lastname=path.get("last_name");
		System.out.println(lastname);
	
	}

}
