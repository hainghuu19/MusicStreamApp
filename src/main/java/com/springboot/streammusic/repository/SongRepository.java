package com.springboot.streammusic.repository;

import com.springboot.streammusic.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
