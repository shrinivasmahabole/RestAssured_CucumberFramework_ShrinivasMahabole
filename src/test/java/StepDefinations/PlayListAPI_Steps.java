package StepDefinations;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import APITest.Pojo.PlayListAPIRequest.PlayListAPIRequestBody;

import APITest.Pojo.PlayListAPIRequest.PojoCreatePlayList;
import TestAPI_Methods.TokenManager;
import TestAPI_Methods.Utils;
import api_Resources.APIResources;

public class PlayListAPI_Steps extends Utils {
	RequestSpecBuilder resquestspecBuilder;
    RequestSpecification requestSpecification;
    ResponseSpecBuilder responseSpecBuilder;
    ResponseSpecification responseSpecification;
    public  Response res;
    public PlayListAPIRequestBody createPlayList;
    public PlayListAPI_Steps() {
    	createPlayList = new PlayListAPIRequestBody();
    }
    
	
	@Given("user form the request with base URI {string}, contentType {string}, basePath {string}")
	public void user_form_the_request_with_base_uri_content_type_base_path_and_payload_parameters_are(String uri, String contentType, String basePath) {
		requestSpecification = given().spec(getRequestSpecification(uri,contentType, basePath)).auth().oauth2(TokenManager.getAccessToken());
	}

	@When("user calls {string} with {string} http method and Payload parameters are {string}, {string}, {string}")
	public void user_calls_with_http_method(String resources, String method, String playlistName, String description, String public_) {
		APIResources value = APIResources.valueOf(resources);
		System.out.println(value.getResource());

		if (method.equalsIgnoreCase("post")) {
			res = requestSpecification.body(requestcreatePlayListBody(playlistName, description, convert(public_))).log().all().when().post(value.getResource());
		} else if (method.equalsIgnoreCase("get")) {
			res = requestSpecification.log().all().when().get(value.getResource());
		} else if (method.equalsIgnoreCase("delete")) {
			res = requestSpecification.log().all().when().delete(value.getResource());
		} else {
			System.out.println("Specific method is not mentioned");
		}
	}
	
	@Then("Validate that user get the status code as {int}")
	public void validate_that_user_get_the_status_code_as(Integer statusCode) {
		PojoCreatePlayList playlistRes = res.then().spec(getResponseSpecification()).assertThat().statusCode(statusCode).extract().response().as(PojoCreatePlayList.class);		  
		 
		 assertThat(playlistRes.getName(), equalTo(createPlayList.getName()));
		 assertThat(playlistRes.getDescription(), equalTo(createPlayList.getDescription()));
		 assertThat(playlistRes.getPublic(), equalTo(createPlayList.getPublic()));
	}
	
	public Boolean convert(String input) {
		if(input.equalsIgnoreCase("true")) {
			return true;
		}else {
			return false;
		}
	}
	
	public PlayListAPIRequestBody requestcreatePlayListBody(String name, String description, boolean public_) {
		createPlayList.setName(name);
		createPlayList.setPublic(public_);
		createPlayList.setDescription(description);
		return createPlayList;
	}	 
	

}
