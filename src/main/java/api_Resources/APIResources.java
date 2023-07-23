package api_Resources;

public enum APIResources {
	
	CreatePlayListAPI("/users/31dkvpyg3kouxd5m4tgi2yam643m/playlists"),
	GetPlayListAPI("users/31dkvpyg3kouxd5m4tgi2yam643m/playlists"),
	GetSpecificPlaylist("playlists/4r95FDST7yCGX330pwZEXc"),
	UpdatePlaylist("playlists/4r95FDST7yCGX330pwZEXc?=&=");
	
	public String resource;
	APIResources(String resource) {
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}

}
