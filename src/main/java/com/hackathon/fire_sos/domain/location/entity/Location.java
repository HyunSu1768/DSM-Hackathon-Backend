package com.hackathon.fire_sos.domain.location.entity;

import com.hackathon.fire_sos.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private Double latitude;

    private Double longitude;

    public void changeLocation(Double latitude, Double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
