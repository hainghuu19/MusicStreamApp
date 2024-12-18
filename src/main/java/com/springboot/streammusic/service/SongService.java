package com.springboot.streammusic.service;

import com.springboot.streammusic.model.Song;
import com.springboot.streammusic.model.UserLikedSong;
import com.springboot.streammusic.repository.SongRepository;
import com.springboot.streammusic.repository.UserFavoriteSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private UserFavoriteSongRepository userFavoriteSongRepository;

    public List<Song> getAllSong(){
        return songRepository.findAll();
    }


    public byte[] getSongFile(String filePath) throws Exception{
        Path path = Paths.get(filePath);
        return Files.readAllBytes(path);
    }

    public List<Song> getFavoriteSongByUserId(int userId){
        List<UserLikedSong> userFavoriteSongRepositories = userFavoriteSongRepository.findByUserId(userId);
        return userFavoriteSongRepositories.stream().map(UserLikedSong::getSong)
                .collect(Collectors.toList());
    }
}
