package com.springboot.streammusic.repository;

import com.springboot.streammusic.model.UserLikedSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserFavoriteSongRepository extends JpaRepository<UserLikedSong, Long> {
    @Query("SELECT uls FROM UserLikedSong uls WHERE uls.user.user_id = :userId")
    List<UserLikedSong> findByUserId(@Param("userId") int userId);
}
