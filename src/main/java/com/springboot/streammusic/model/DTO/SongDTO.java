package com.springboot.streammusic.model.DTO;

import lombok.Data;
import java.util.Date;

@Data
public class SongDTO {
    private Long songId;
    private String title;
    private String artistName;
    private String albumTitle;
    private String genre;
    private Integer duration;
    private String audioFilePath;
    private Integer playCount;
    private Date releaseDate;
    private int likeCount;

    // Constructor
    public SongDTO() {}

    // Constructor với tất cả các trường
    public SongDTO(Long songId, String title, String artistName, String albumTitle,
                   String genre, Integer duration, String audioFilePath,
                   Integer playCount, Date releaseDate, int likeCount) {
        this.songId = songId;
        this.title = title;
        this.artistName = artistName;
        this.albumTitle = albumTitle;
        this.genre = genre;
        this.duration = duration;
        this.audioFilePath = audioFilePath;
        this.playCount = playCount;
        this.releaseDate = releaseDate;
        this.likeCount = likeCount;
    }
}
