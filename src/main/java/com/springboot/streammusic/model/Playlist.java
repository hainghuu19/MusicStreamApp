package com.springboot.streammusic.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "PLAYLISTS")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playlist_id;

    @ManyToOne
    @JoinColumn(name = "user_playlist_id")
    private UserPlaylist userPlaylist;

    @ManyToMany
    @JoinTable(
            name = "playlist_song", // Tên bảng trung gian
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Song> songs = new ArrayList<>();

    private Integer position;

    private LocalDateTime added_at;


}
