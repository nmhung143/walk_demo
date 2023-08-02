package com.demo.application.utils;

import com.demo.application.security.UserRepoDetails;
import com.demo.domain.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * @author : hung.nguyenmanh
 * @created : 7/2/2023
 **/
@Slf4j
public class JwtUtils implements Serializable {
    private final String jwtIssuer;
    private final String jwtAudience;
    private final String jwtSecret;
    private byte[] signingKey;
    private final long jwtExpirationMinutes;

    @PostConstruct
    private void initKey() {
        signingKey = jwtSecret.getBytes();
    }

    public JwtUtils(String jwtIssuer,
                    String jwtAudience,
                    String jwtSecret,
                    long jwtExpirationMinutes) {
        this.jwtIssuer = jwtIssuer;
        this.jwtAudience = jwtAudience;
        this.jwtSecret = jwtSecret;
        this.jwtExpirationMinutes = jwtExpirationMinutes;
    }

    public String generate(Authentication authentication) {
        var userDetails = (UserRepoDetails) authentication.getPrincipal();
        return generateAuthenticationJwt(userDetails.getUser());
    }

    public String generateAuthenticationJwt(User user) {
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(jwtExpirationMinutes).toInstant()))
                .setIssuedAt(Date.from(ZonedDateTime.now().toInstant()))
                .setId(UUID.randomUUID().toString())
                .setIssuer(jwtIssuer)
                .setAudience(jwtAudience)
                .setSubject(user.getUsername())
                .claim("userId", user.getId())
                .compact();
    }

    public Optional<Jws<Claims>> validateTokenAndGetJws(String token) {
        try {
            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(token);

            return Optional.of(jws);
        } catch (Exception e) {
            log.error("Request to parse expired JWT : {} failed : {}", token, e.getMessage());
        }
        return Optional.empty();
    }

}
