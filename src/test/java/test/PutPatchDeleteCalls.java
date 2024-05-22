package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutPatchDeleteCalls {

	@SuppressWarnings("unchecked")
	@Test
	public void test_put() {

		baseURI = "https://reqres.in/api";

		JSONObject request = new JSONObject();
		request.put("Name", "Prabhagar");
		request.put("Job", "Automation Tester");
		System.out.println(request.toJSONString());

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();

	}

	@SuppressWarnings("unchecked")
	@Test
	public void test_patch() {

		baseURI = "https://reqres.in/api";

		JSONObject request = new JSONObject();
		request.put("Name", "Prabhagar");
		request.put("Job", "Automation Tester");
		System.out.println(request.toJSONString());

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().patch("/users/2").then().statusCode(200).log().all();

	}

	@SuppressWarnings("unchecked")
	@Test
	public void test_delete() {

		baseURI = "https://reqres.in/api";

		when().delete("/users/2").then().statusCode(204).log().all();

	}

}
