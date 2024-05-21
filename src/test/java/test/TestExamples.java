package test;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

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
	public void testWithBDD() {

		RestAssured.baseURI = "https://reqres.in/api";

		given()
			.get("/users?page=2")
			.then()
			.statusCode(200)
			.body("data[0].id", equalTo(7))
			.body("data.first_name", hasItems("Michael", "Byron"));
	}

}
