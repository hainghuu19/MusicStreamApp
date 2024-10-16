package com.springboot.streammusic.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    private String profilePicture;

    @Temporal(TemporalType.DATE)
    private Date createdAt;

    private boolean isPremium;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private Set<Playlist> playlists = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "USER_LIKED_SONGS",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private Set<Song> likedSongs = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "FOLLOWS",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    private Set<User> following = new HashSet<>();

    @ManyToMany(mappedBy = "following")
    private Set<User> followers = new HashSet<>();
}
