package com.springboot.streammusic.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;


@Data
@Embeddable
public class UserLikedSongId {
    private Long userId;
    private Long songId;

    // equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLikedSongId that = (UserLikedSongId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(songId, that.songId);

    }
    @Override
    public int hashCode() {
        return Objects.hash(userId, songId);
    }
}
