package com.qa.practice;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC03_Put_Call_Request
{
	//Put Call means Update the Data
	
	@Test
	public void put_CallTest()
	{
		
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification httprequest=RestAssured.given();
		
		httprequest.header("Content-Type","application/json; charset=utf-8");
		
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("title", "Manual");
		jsonobject.put("job", "Testing");
		
		httprequest.body(jsonobject.toJSONString());
		
		Response response=httprequest.put("/posts/1");
		System.out.println(response.getBody().asString());

		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		
		String statusline=response.getStatusLine();
		System.out.println(statusline);
		
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
}
