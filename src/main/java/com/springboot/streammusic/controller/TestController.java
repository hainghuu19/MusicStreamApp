package com.springboot.streammusic.controller;

import com.springboot.streammusic.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final SpotifyService spotifyService;

    @Autowired
    public TestController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping("/test-spotify")
    public String testSpotify() {
        try {
            spotifyService.authenticateClient();
            return "Spotify authentication successful!";
        } catch (Exception e) {
            return "Spotify authentication failed: " + e.getMessage();
        }
    }
}
