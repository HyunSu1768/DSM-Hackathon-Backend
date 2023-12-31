package com.hackathon.fire_sos.global.config.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Component
public class JwtResolver {

    private String header = "Authorization";

    private String prefix = "Bearer";

    public String resolveToken(HttpServletRequest request){

        String bearerToken = request.getHeader(header);

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(prefix)
                && bearerToken.length() > prefix.length()+1){
            return bearerToken.substring(7);
        }
        return null;
    }
}
