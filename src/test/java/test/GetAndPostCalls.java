package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetAndPostCalls {

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
