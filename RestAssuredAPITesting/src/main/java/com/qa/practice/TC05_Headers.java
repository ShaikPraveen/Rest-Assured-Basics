package com.qa.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC05_Headers 
{
	@Test
	public void headersVerifyTest()
	{	
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification httprequest=RestAssured.given();
		Response response=httprequest.request(Method.GET,"/posts/");
		System.out.println(response.getBody().asString());
		
	    int statuscode=response.getStatusCode();
	    System.out.println(statuscode);
	    
	    Assert.assertEquals(statuscode, 200);
	    
	    String statusline=response.getStatusLine();
	    System.out.println(statusline);
		
	    Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	    
		Headers headers=response.headers();
		System.out.println(headers);
		
		String xray=response.getHeader("X-Powered-By");
		System.out.println(xray);
		
		String vary= response.getHeader("Vary");
		System.out.println(vary);
		
		String ContentType=response.getHeader("Content-Type");
		System.out.println(ContentType);
		
		String ContentLength=response.getHeader("Content-Length");
		System.out.println(ContentLength);
		
		String Connection=response.getHeader("Connection");
		System.out.println(Connection);
		
		
		Assert.assertEquals(xray.contains("Express"), true);
		Assert.assertEquals(vary.contains("Origin, Accept-Encoding"), true);
		Assert.assertEquals(ContentType.contains("application/json; charset=utf-8"), true);
		Assert.assertEquals(ContentLength.contains("710"), true);
		Assert.assertEquals(Connection.contains("keep-alive"), true);
	}
}
