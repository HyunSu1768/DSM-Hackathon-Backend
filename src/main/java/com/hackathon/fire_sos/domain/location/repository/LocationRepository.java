package com.hackathon.fire_sos.domain.location.repository;

import com.hackathon.fire_sos.domain.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
