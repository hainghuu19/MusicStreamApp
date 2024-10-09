package com.springboot.streammusic.repository;

import com.springboot.streammusic.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtisRepository extends JpaRepository<Artist, Long> {
}
