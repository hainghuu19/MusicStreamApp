package com.springboot.streammusic.model.DTO;

import java.util.Date;
import java.util.List;

public class UserProfileDTO {
    private Integer userId;
    private String username;
    private String email;
    private String profilePicture;
    private Date createdAt;
    private boolean isPremium;
    private List<SongDTO> likedSongs;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public List<SongDTO> getLikedSongs() {
        return likedSongs;
    }

    public void setLikedSongs(List<SongDTO> likedSongs) {
        this.likedSongs = likedSongs;
    }
}
