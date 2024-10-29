package com.springboot.streammusic.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


@Service
public class TokenBlaclistService {
    private final Map<String, Boolean> blacklist = new ConcurrentHashMap<>();

    public void addToBlacklist(String token){
        blacklist.put(token, true);
    }

    public Boolean isBlacklisted(String token){
        return blacklist.containsKey(token);
    }
}
