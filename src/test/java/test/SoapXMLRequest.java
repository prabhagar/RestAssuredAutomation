package test;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SoapXMLRequest {
	
	@Test
	public void ValidateSoapXml() throws IOException {
		
		File file = new File("Add.xml");
		
		if(file.exists())
			System.out.println("   >> File Exists");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
		baseURI = "https://ecs.syr.edu";
		
		given()
			.contentType("text/xml")
			.accept(ContentType.XML)
			.body(requestBody)
		.when()
			.post("/faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx?op=Add")
		.then()
			.statusCode(200).log().all();
	}

}
