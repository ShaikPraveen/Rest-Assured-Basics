package com.qa.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC06_JsonPath
{
	
	@Test
	public void jsonPathTest()
	{
		
		RestAssured.baseURI="http://localhost:3000/posts/10";
		RequestSpecification httprequest=RestAssured.given();
		Response response=httprequest.request(Method.GET);
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
		JsonPath jsonpath=response.jsonPath();
		int id=jsonpath.get("id");
		String title=jsonpath.get("title");
		String job=jsonpath.getString("job");
		/*System.out.println(id);
		System.out.println(title);
		System.out.println(job);*/
		
		Assert.assertEquals(id, 10,"ID NOT MATCHED");
		Assert.assertEquals(title, "Automation","TITLE NOT MATCHED");
		Assert.assertEquals(job, "TESTING","JOB NOT MATCHED");	
	}
}
