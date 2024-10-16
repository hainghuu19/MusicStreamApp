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
    private Long id;

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

    private String audioUrl;

    private Integer playCount = 0;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @ManyToMany(mappedBy = "likedSongs")
    private Set<User> likedByUsers = new HashSet<>();

    @ManyToMany(mappedBy = "songs")
    private Set<Playlist> playlists = new HashSet<>();


}
