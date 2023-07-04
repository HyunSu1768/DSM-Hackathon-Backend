package com.hackathon.fire_sos.domain.report.repository;

import com.hackathon.fire_sos.domain.report.domain.Report;
import com.hackathon.fire_sos.domain.user.entity.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query(value = "SELECT d.* FROM Report d WHERE (6371 * acos(cos(radians(:latitude)) * cos(radians(d.latitude)) * cos(radians(d.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(d.latitude)))) <= :radius", nativeQuery = true)
    List<Report> findNearbyDisasters(@Param("latitude") double latitude, @Param("longitude") double longitude, @Param("radius") double radius);

    List<Report> findAllByReporter(User Reporter);

    @Query("SELECT r FROM Report r WHERE r.createdAt >= :startDate")
    List<Report> findReportsFromLastWeek(@Param("startDate") LocalDateTime startDate);

}
