package TestAPI_Methods;

import java.time.Instant;
import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TokenManager {
	
	public static String accesstoken;
	public static Instant expiryTime;
	
	public static String getAccessToken() {
		try {
			if (accesstoken == null || Instant.now().isAfter(expiryTime)) {
				System.out.println("Renewing Access Token...!!");
				Response res = accesstoken();
				accesstoken = res.path("access_token");
				int expiryDuration = res.path("expires_in");
				expiryTime = Instant.now().plusSeconds(expiryDuration - 300);
			} else {
				System.out.println("Access token is good to use within expiry time");
			} 
		} catch (Exception e) {
			throw new RuntimeException("ABORT!!, FAILED TO CREATE ACCCESS TOKEN");
		}
		return accesstoken;
	}
	
	public static Response accesstoken() {
		HashMap<String, String> formParameter = new HashMap<String, String>();
		formParameter.put("client_id", Configloader.getinstance().getClientID());
		formParameter.put("client_secret", Configloader.getinstance().getclient_secret());
		formParameter.put("grant_type", Configloader.getinstance().getgrant_type());
		formParameter.put("refresh_token", Configloader.getinstance().getrefresh_token());
		
		Response res = Utils.accountAPI(formParameter);
		
		if(res.getStatusCode() != 200) {
			throw new RuntimeException("!! ABORT!, Renew token failed");
		}
		return res;
	}

}
