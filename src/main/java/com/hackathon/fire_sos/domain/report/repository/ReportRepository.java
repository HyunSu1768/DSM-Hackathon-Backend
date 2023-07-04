package com.hackathon.fire_sos.domain.report.repository;

import com.hackathon.fire_sos.domain.report.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
