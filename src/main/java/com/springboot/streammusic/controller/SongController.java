package com.springboot.streammusic.controller;


import com.springboot.streammusic.model.Album;
import com.springboot.streammusic.model.DTO.SongDTO;
import com.springboot.streammusic.model.DTO.SongMapper;
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
    @Autowired
    private SongMapper songMapper;

//    @GetMapping("/get-all-songs")
//    public List<Song> getAllSongs(){
//        return songService.getAllSong();
//    }
@GetMapping("/get-all-songs")
public ResponseEntity<List<SongDTO>> getAllSongs() {
    List<Song> songs = songService.getAllSong();
    return ResponseEntity.ok(songMapper.toDTOList(songs));
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

    @GetMapping("/get-favorite-songs/{userId}")
    public ResponseEntity<List<Song>> getUserFavoriteSongs(@PathVariable int userId){
        List<Song> favoriteSongs = songService.getFavoriteSongByUserId(userId);
        return ResponseEntity.ok(favoriteSongs);
    }

    @GetMapping("get-album")
    public List<Album> getAllAlbum(){
        return songService.getAllAlbum();
    }


}
