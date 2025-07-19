package com.microservices.api_gateway.config;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.*;

import javax.crypto.SecretKey;

@Configuration
public class JwtDecoderConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public ReactiveJwtDecoder jwtDecoder() {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        return NimbusReactiveJwtDecoder.withSecretKey(key).build();
    }
}
