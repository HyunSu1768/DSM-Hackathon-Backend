package com.hackathon.fire_sos.domain.user.repository;

import com.hackathon.fire_sos.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountId(String accountId);

    Optional<User> findByAccountId(String accountId);

    @Query(value = "SELECT user.*, ( 6371 * acos ( cos ( radians(?1) ) * cos( radians( location.latitude ) ) * cos( radians( location.longitude ) - radians(?2) ) + sin ( radians(?1) ) * sin( radians( location.latitude ) ) ) ) AS distance FROM user INNER JOIN location ON user.location_id = location.id HAVING distance < 0.1 ORDER BY distance", nativeQuery = true)
    List<User> findUsersInRadius(double latitude, double longitude);


}
