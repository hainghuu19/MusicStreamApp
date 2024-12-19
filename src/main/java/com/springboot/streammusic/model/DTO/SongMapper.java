package com.springboot.streammusic.model.DTO;

import com.springboot.streammusic.model.Song;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SongMapper {
    public SongDTO toDTO(Song song) {
        return new SongDTO(
                song.getSong_id(),
                song.getTitle(),
                song.getArtist() != null ? song.getArtist().getName() : null,
                song.getAlbum() != null ? song.getAlbum().getTitle() : null,
                song.getGenre(),
                song.getDuration(),
                song.getAudioFilePath(),
                song.getPlay_count(),
                song.getRelease_date(),
                song.getLikedByUsers() != null ? song.getLikedByUsers().size() : 0
        );
    }

    public List<SongDTO> toDTOList(List<Song> songs) {
        return songs.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
