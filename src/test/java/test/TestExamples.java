package test;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class TestExamples {

	@Test
	public void test_Get() {

		RestAssured.baseURI = "https://reqres.in/api";

		Response response = get("/users?page=2");

		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getContentType());
		System.out.println(response.getStatusLine());
		System.out.println(response.getSessionId());

		response.getStatusCode();
		response.getContentType();

		int statusCode = response.statusCode();

		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void testPost() {

		RestAssured.baseURI = "https://reqres.in/api";

		given()
			.get("/users?page=2")
			.then()
			.statusCode(200)
			.body("data[0].id", equalTo(7))
			.body("data.first_name", hasItems("Michael", "Byron"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testWithHashMap() {

		baseURI = "https://reqres.in/api";
		
		JSONObject request = new JSONObject();
		request.put("Name", "Prabhagar");
		request.put("Job", "Automation Tester");
		System.out.println(request.toJSONString());
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
			.when()
			.post("/users")
			.then()
			.statusCode(201)
			.log().all();
		
	}

}
