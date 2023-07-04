package com.hackathon.fire_sos.domain.report.controller.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReportRequest {

    private Double latitude;

    private Double longitude;

    private String place;

}
