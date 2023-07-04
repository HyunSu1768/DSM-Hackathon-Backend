package com.hackathon.fire_sos.domain.user.repository;


import com.hackathon.fire_sos.domain.user.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {

    Optional<RefreshToken> findByToken(String token);
}
