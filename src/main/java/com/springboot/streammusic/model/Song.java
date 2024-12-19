package com.springboot.streammusic.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "SONGS")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long song_id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    private String genre;

    @Column(nullable = false)
    private Integer duration;

    private String audioFilePath;

    private Integer play_count = 0;

    @Temporal(TemporalType.DATE)
    private Date release_date;

    @ManyToMany(mappedBy = "likedSongs")
    private Set<User> likedByUsers = new HashSet<>();

    @ManyToMany(mappedBy = "songs")
    private Set<Playlist> playlists = new HashSet<>();

    public Long getSong_id() {
        return song_id;
    }

    public Integer getPlay_count() {
        return play_count;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public Long getId() {
        return song_id;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public Album getAlbum() {
        return album;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getAudioFilePath() {
        return audioFilePath;
    }

    public Integer getPlayCount() {
        return play_count;
    }

    public Date getReleaseDate() {
        return release_date;
    }

    public Set<User> getLikedByUsers() {
        return likedByUsers;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }
}
