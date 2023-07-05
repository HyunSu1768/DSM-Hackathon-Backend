package com.hackathon.fire_sos.domain.report.domain;

import com.hackathon.fire_sos.domain.user.entity.User;
import com.hackathon.fire_sos.global.common.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Report extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User reporter;

    private String place;

    private Double latitude;

    private Double longitude;

    private String description;

    private boolean isCompleted;

}
