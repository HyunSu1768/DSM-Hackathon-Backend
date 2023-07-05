package com.hackathon.fire_sos.domain.report.controller.dto.response;

import com.hackathon.fire_sos.domain.report.domain.Report;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ReportMainResponse {

    private Long reportId;

    private String reporter;

    private String place;

    private LocalDateTime reportedAt;

    private String description;

    public static ReportMainResponse of(Report report){
        return ReportMainResponse.builder()
                .description(report.getDescription())
                .reportId(report.getId())
                .place(report.getPlace())
                .reportedAt(report.getCreatedAt())
                .reporter(report.getReporter().getAccountId())
                .build();

    }

}
