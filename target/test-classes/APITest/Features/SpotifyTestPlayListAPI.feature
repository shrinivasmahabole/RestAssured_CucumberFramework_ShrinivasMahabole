Feature: PlayList API Testing

Scenario: Validate that User is able to create the PlayList in Spotify using create Play list API
Given user form the request with base URI "https://api.spotify.com", contentType "application/json", basePath "/v1"
When user calls "CreatePlayListAPI" with "POST" http method and Payload parameters are "My New PlayList_02", "Test Describe", "false" 
Then Validate that user get the status code as 201


