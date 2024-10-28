package com.springboot.streammusic.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "ARTISTS")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artist_id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String bio;


    private String profile_picture;

    @Temporal(TemporalType.DATE)
    private Date created_at;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private Set<Song> songs = new HashSet<>();

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private Set<Album> albums = new HashSet<>();


}
