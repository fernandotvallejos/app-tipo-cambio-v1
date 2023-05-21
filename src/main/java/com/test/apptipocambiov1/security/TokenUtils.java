package com.test.apptipocambiov1.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    private final static String ACCESS_TOKE_SECRET="UkXp2s5v8y/B?E(H+KbPeShVmYq3t6w9";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2592000L;


    public static String createToken(String username, String subject){
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000L;
        Date expirationDate = new Date(System.currentTimeMillis()+expirationTime);

        Map<String,Object> extra = new HashMap<>();
        extra.put("nombre", username);

        return Jwts.builder()
                .setSubject(subject)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKE_SECRET.getBytes()))
                .compact();

    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try{
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKE_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String subject = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(subject,null, Collections.emptyList());
        }catch(JwtException e){
            return null;
        }


    }

}
