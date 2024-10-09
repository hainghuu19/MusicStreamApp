package com.springboot.streammusic.repository;

import com.springboot.streammusic.model.UserLikedSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLikeSongRepository extends JpaRepository<UserLikedSong, Long> {
}
