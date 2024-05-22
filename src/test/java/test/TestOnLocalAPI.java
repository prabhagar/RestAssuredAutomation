package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestOnLocalAPI {

	@Test
	public void get() {
		baseURI = "http://localhost:3000/";

		given().get("/users").then().statusCode(200).log().all();

	}

	@Test
	public void post() {

		baseURI = "http://localhost:3000";

		JSONObject request = new JSONObject();
		request.put("firstName", "prabu");
		request.put("lastname", "tamil");
		request.put("subjectId", 1);

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
				.post("/users").then().statusCode(201).log().all();
	}
	
	@Test
	public void put() {

		baseURI = "http://localhost:3000";

		JSONObject request = new JSONObject();
		request.put("firstName", "Prabhagar");
		request.put("lastname", "Tamizhselvan");
		request.put("subjectId", 3);

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
				.put("/users/46b8").then().statusCode(200).log().all();
	}

	@Test
	public void patch() {

		baseURI = "http://localhost:3000";

		JSONObject request = new JSONObject();
		request.put("lastname", "Tamizh");

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
				.patch("/users/46b8").then().statusCode(200).log().all();
	}
	
	@Test
	public void delete() {

		baseURI = "http://localhost:3000";

		when()
			.patch("/users/757c").then().statusCode(200);
	}
}
