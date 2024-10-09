package com.springboot.streammusic.repository;

import com.springboot.streammusic.model.UserPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPlaylistRepository extends JpaRepository<UserPlaylist, Long> {
}
