package com.springboot.streammusic.service;

import com.springboot.streammusic.model.Song;
import com.springboot.streammusic.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public List<Song> getAllSong(){
        return songRepository.findAll();
    }


    public byte[] getSongFile(String filePath) throws Exception{
        Path path = Paths.get(filePath);
        return Files.readAllBytes(path);
    }
}
