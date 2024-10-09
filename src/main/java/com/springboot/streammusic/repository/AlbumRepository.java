package com.springboot.streammusic.repository;

import com.springboot.streammusic.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
