package com.hackathon.fire_sos.domain.report.domain;

import com.hackathon.fire_sos.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Report {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User reporter;

    private String place;

    private Double latitude;

    private Double longitude;

    private boolean isCompleted;

}
