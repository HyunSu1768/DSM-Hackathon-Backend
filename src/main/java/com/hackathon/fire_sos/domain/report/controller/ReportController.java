package com.hackathon.fire_sos.domain.report.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.hackathon.fire_sos.domain.report.controller.dto.request.ReportRequest;
import com.hackathon.fire_sos.domain.report.controller.dto.response.ReportMainResponse;
import com.hackathon.fire_sos.domain.report.controller.dto.response.ReportResponseList;
import com.hackathon.fire_sos.domain.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @PostMapping
    public void createReport(@RequestBody ReportRequest request) throws FirebaseMessagingException {
        reportService.createReport(request);
    }

    @GetMapping("/near")
    public ReportResponseList findNearReports(){
        return reportService.findNearReport();
    }

    @GetMapping("/my")
    public ReportResponseList findMyReports(){
        return reportService.findMyReport();
    }

    @GetMapping("/all")
    public ReportResponseList findAllReports(){
        return reportService.findAllReport();
    }

    @GetMapping("/main")
    public ReportMainResponse findMainReport(){
        return reportService.findMainReport();
    }

}
