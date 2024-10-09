package com.springboot.streammusic.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "USERS_PLAYLIST")
public class UserPlaylist {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long playlistId;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @Column(nullable = false)
        private String name;

        @Column(columnDefinition = "TEXT")
        private String description;

        private LocalDateTime createdAt;

        private Boolean isPublic = true;

        private String coverImage;

        @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
        private Set<Playlist> playlist = new HashSet<>();

}
