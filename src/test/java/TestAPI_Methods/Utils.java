package TestAPI_Methods;

import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import APITest.Pojo.PlayListAPIRequest.PlayListAPIRequestBody;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	RequestSpecification requestSpecification;
	RequestSpecBuilder resquestspecBuilder;
	FileInputStream fis;
	Properties prop;
	
	public static RequestSpecification getRequestSpecification(String baseuri, String contenttype, String basePath) {
		
		return new RequestSpecBuilder().
				setBaseUri(baseuri).
				setBasePath(basePath).				
				addHeader("Content-Type", contenttype).
				log(LogDetail.ALL).build();		
	}
	
	public static ResponseSpecification getResponseSpecification() {
		return new ResponseSpecBuilder().log(LogDetail.ALL).build();
	}
	
	public  String globalProp(String key) {
		try {
			fis = new FileInputStream("src/test/resources/global.properties");
			Properties prop = new Properties();
			try {
				prop.load(fis);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop.getProperty(key);
	}
	
	public static Response accountAPI(HashMap<String, String> formparam) {
		Response res = given().baseUri(Configloader.getinstance().getaccountapi_baseuri()).
				contentType(ContentType.URLENC).
				formParams(formparam).
				when().post(Configloader.getinstance().getaccountapi_resource()).
				then().spec(Utils.getResponseSpecification()).extract().response();
		return res;
	}
	
	public static Properties propertyLoader(String filePath) {
		Properties prop = new Properties();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			try {
				prop.load(reader);
				reader.close();
			} catch (IOException e) {

				e.printStackTrace();
				throw new RuntimeException("Failed to load properties file!! " + filePath);
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			throw new RuntimeException("Properties file not found !! " + filePath);
		}
		return prop;

	}
	
}
