package TestAPI_Methods;

import java.util.Properties;

public class Configloader {
	private final Properties prop;
	private static  Configloader config;
	private Configloader() {
		prop = Utils.propertyLoader("src/test/resources/config.properties");
	}
	
	public static Configloader getinstance() {
		if(config == null) {
			config = new Configloader();
		}
		return config;
	}
	
	public String getClientID() {
		String value = prop.getProperty("client_id");
		if(value != null) return value;
		else throw new RuntimeException("The Key value is not defined in the Config.property file");
	}
	public String getclient_secret() {
		String value = prop.getProperty("client_secret");
		if(value != null) return value;
		else throw new RuntimeException("The Key value is not defined in the Config.property file");
	}
	public String getgrant_type() {
		String value = prop.getProperty("grant_type");
		if(value != null) return value;
		else throw new RuntimeException("The Key value is not defined in the Config.property file");
	}
	public String getrefresh_token() {
		String value = prop.getProperty("refresh_token");
		if(value != null) return value;
		else throw new RuntimeException("The Key value is not defined in the Config.property file");
	}
	
	public String getaccountapi_baseuri() {
		String value = prop.getProperty("accountapi_baseuri");
		if(value != null) return value;
		else throw new RuntimeException("The Key value is not defined in the Config.property file");
	}
	public String getaccountapi_resource() {
		String value = prop.getProperty("accountapi_resource");
		if(value != null) return value;
		else throw new RuntimeException("The Key value is not defined in the Config.property file");
	}

}
