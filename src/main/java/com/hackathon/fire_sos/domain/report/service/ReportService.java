package com.hackathon.fire_sos.domain.report.service;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.hackathon.fire_sos.domain.report.controller.dto.request.ReportRequest;
import com.hackathon.fire_sos.domain.report.domain.Report;
import com.hackathon.fire_sos.domain.report.repository.ReportRepository;
import com.hackathon.fire_sos.domain.user.entity.User;
import com.hackathon.fire_sos.domain.user.repository.UserRepository;
import com.hackathon.fire_sos.domain.user.service.UserFacade;
import com.hackathon.fire_sos.infra.firebase.FirebaseCloudMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ReportService {

    private final FirebaseCloudMessageService firebaseCloudMessageService;

    private final UserRepository userRepository;

    private final ReportRepository reportRepository;

    private final UserFacade userFacade;

    public void createReport(ReportRequest request) throws FirebaseMessagingException {

        Report report = Report.builder()
                .reporter(userFacade.currentUser())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .place(request.getPlace())
                .isCompleted(false)
                .build();

        reportRepository.save(report);

        notification(report);

    }

    public void notification(Report report) throws FirebaseMessagingException {
        List<User> userList = userRepository.findUsersInRadius(report.getLatitude(), report.getLongitude());
        for (User user : userList){
            String deviceToken = user.getDeviceToken();
            firebaseCloudMessageService.sendMessage(1,deviceToken);
        }
    }

}

