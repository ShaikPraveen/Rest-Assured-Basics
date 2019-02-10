package com.qa.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC04_Delete_Call_Request
{
	//Delete Call means to Delete the Data
	
	
	@Test
	public void deleteCallTest()
	{
		
		RestAssured.baseURI="http://localhost:3000/posts/9";
		RequestSpecification httprequest=RestAssured.given();
		
		Response response=httprequest.delete();
		System.out.println(response.getBody().asString());
		
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		
		String statusline=response.getStatusLine();
		System.out.println(statusline);
		
		//Success Data Delete Verification
		//Assert.assertEquals(statuscode,200);
	    //Assert.assertEquals(statusline, "HTTP/1.1 200 OK");	
	    
	    //After delte the Recored validation
	    Assert.assertEquals(statuscode, 404);
	    Assert.assertEquals(statusline, "HTTP/1.1 404 Not Found");
	}
}
