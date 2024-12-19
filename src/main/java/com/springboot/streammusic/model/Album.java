package com.springboot.streammusic.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "ALBUMS")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer album_id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    private String cover_image;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private Set<Song> songs = new HashSet<>();


    public Integer getAlbum_id() {
        return album_id;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
}
