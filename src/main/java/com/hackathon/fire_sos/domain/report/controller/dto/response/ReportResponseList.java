package com.hackathon.fire_sos.domain.report.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ReportResponseList {

    private List<ReportResponse> reportResponseList;
}
