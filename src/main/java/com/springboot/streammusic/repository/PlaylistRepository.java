package com.springboot.streammusic.repository;

import com.springboot.streammusic.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
