package com.springboot.streammusic.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "USER_LIKED_SONGS")
public class UserLikedSong {
    @EmbeddedId
    private UserLikedSongId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne  // before ManyToOne
    @MapsId("songId")
    @JoinColumn(name = "song_id")
    private Song song;

    private LocalDateTime likedAt;

    public Song getSong(){
        return song;
    }

    public UserLikedSongId getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getLikedAt() {
        return likedAt;
    }
}
