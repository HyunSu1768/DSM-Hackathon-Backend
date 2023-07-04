package com.hackathon.fire_sos.domain.report.controller.dto.response;

import com.hackathon.fire_sos.domain.report.domain.Report;
import com.hackathon.fire_sos.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReportResponse {

    private Long reportId;

    private String reporter;

    private String place;

    private Double latitude;

    private Double longitude;

    private Boolean isCompleted;

    public static ReportResponse of(Report report){
        return ReportResponse.builder()
                .isCompleted(report.isCompleted())
                .reportId(report.getId())
                .latitude(report.getLatitude())
                .longitude(report.getLongitude())
                .place(report.getPlace())
                .reporter(report.getReporter().getAccountId())
                .build();
    }


}
