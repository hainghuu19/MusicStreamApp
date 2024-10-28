package com.springboot.streammusic.controller;


import com.springboot.streammusic.model.Song;
import com.springboot.streammusic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public List<Song> getAllSongs(){
        return songService.getAllSong();
    }

    @GetMapping("/play/{id}")
    public ResponseEntity<byte[]> playSong(@PathVariable Long id) {
        try {
            Song song = songService.getAllSong().stream()
                    .filter(s -> s.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Bài hát không tồn tại"));

            byte[] songData = songService.getSongFile(song.getAudioFilePath());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + song.getTitle() + ".mp3\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(songData);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
