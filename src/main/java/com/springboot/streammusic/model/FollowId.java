package com.springboot.streammusic.model;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class FollowId implements Serializable {

    private Integer followerId;
    private Integer followingId;

    // Constructors
    public FollowId() {}

    public FollowId(Integer followerId, Integer followingId) {
        this.followerId = followerId;
        this.followingId = followingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowId followId = (FollowId) o;
        return Objects.equals(followerId, followId.followerId) &&
                Objects.equals(followingId, followId.followingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followerId, followingId);
    }

}
