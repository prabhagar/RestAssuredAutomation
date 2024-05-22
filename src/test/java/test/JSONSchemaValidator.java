package test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class JSONSchemaValidator {
	
	@Test
	public void testPost() {

		RestAssured.baseURI = "https://reqres.in/api";

		given()
			.get("/users?page=2")
			.then()
			.assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
			.statusCode(200)
			.body("data[0].id", equalTo(7))
			.body("data.first_name", hasItems("Michael", "Byron"));
		
//		get("/products").then().assertThat().body(matchesJsonSchemaInClasspath("products-schema.json"));
	}

}
