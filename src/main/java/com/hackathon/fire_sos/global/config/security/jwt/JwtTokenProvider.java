package com.hackathon.fire_sos.global.config.security.jwt;



import com.hackathon.fire_sos.domain.user.controller.dto.response.LoginResponse;
import com.hackathon.fire_sos.domain.user.entity.RefreshToken;
import com.hackathon.fire_sos.domain.user.repository.RefreshTokenRepository;
import com.hackathon.fire_sos.domain.user.repository.UserRepository;
import com.hackathon.fire_sos.global.error.exception.ExpiredTokenException;
import com.hackathon.fire_sos.global.error.exception.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private Long accessExp = 1800 * 1000L;

    private Long refreshExp = 432000* 1000L;

    private String secretKey = "jaskldfkjlasdjflasdhjfklashdjfklashdfklasdhfkas";

    private final RefreshTokenRepository refreshTokenRepository;

    private final UserRepository userRepository;

    public LoginResponse createToken(String accountId) {

        String accessToken = createAccessToken(accountId);
        String refreshToken = createRefreshToken();

        refreshTokenRepository.save(
            RefreshToken.builder()
                .accountId(accountId)
                .token(refreshToken)
                .build()
        );

        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public LoginResponse reIssue(String rfToken) {

        RefreshToken token = refreshTokenRepository.findByToken(rfToken)
                .orElseThrow(()-> InvalidTokenException.EXCEPTION);

        String accountId = userRepository.findByAccountId(token.getAccountId())
                .orElseThrow(() -> InvalidTokenException.EXCEPTION).getAccountId();

        refreshTokenRepository.delete(token);

        return createToken(accountId);
    }


    //JWT 토큰 생성
    private String createAccessToken(String accountId) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(accountId)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + accessExp))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    private String createRefreshToken(){

        Date now = new Date();

        String rfToken = Jwts.builder()
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + refreshExp))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return rfToken;
    }

    //토큰에서 회원 정보 추출
    private Claims getBody(String token){
        try{
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (JwtException e){
            throw InvalidTokenException.EXCEPTION;
        }
    }

    public String getSubjectWithExpiredCheck(String token){

        Claims body = getBody(token);

        if(body.getExpiration().before(new Date())) {
           throw ExpiredTokenException.EXCEPTION;
        } else {
            return body.getSubject();
        }
    }
}
