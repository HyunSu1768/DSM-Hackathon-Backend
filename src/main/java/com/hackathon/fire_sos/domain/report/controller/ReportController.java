package com.hackathon.fire_sos.domain.report.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.hackathon.fire_sos.domain.report.controller.dto.request.ReportRequest;
import com.hackathon.fire_sos.domain.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @PostMapping
    public void createReport(@RequestBody ReportRequest request) throws FirebaseMessagingException {
        reportService.createReport(request);
    }

}
