package com.springboot.streammusic.utility;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "d67d4e2be44af9133f6507241845b470c9e673c9b7c0e8438f6cf4f36de82b250c2c0b4fcadcd837c9557e80c5d6ffe66d78ec638f2524381800c968b2d76ff960ea504f8583ecd93d6b2350260d5c7bc70822959d32449b1771ebadcfdf69dd1ae5ca0ae86de76fc4c1d362acdd81fb359231ee18606f71b8be6e27f81ef625551d448c617c33c8efcd58ae4e71704e4c97d2ce6ec7e43d1df428c1cdba296f09686a3c6ed3e435191c10f7a561c7201e3d18bfaf14547891092c5916fbe9dcd558ee5d2962a21334a1d1a90738de7df73856f2fe89ce26a46095731d25982b9b249985855729113ac556fb3b39d38cc6446a5a917f16572a843241e0b02448";
    private static final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public boolean isTokenValid(String token) {
        return extractClaims(token).getExpiration().after(new Date());
    }

    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
