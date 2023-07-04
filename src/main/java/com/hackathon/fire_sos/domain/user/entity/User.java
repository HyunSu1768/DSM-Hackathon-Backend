package com.hackathon.fire_sos.domain.user.entity;

import javax.persistence.*;

import com.hackathon.fire_sos.domain.location.entity.Location;
import com.hackathon.fire_sos.global.common.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accoundId", nullable = false)
    private String accountId;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(name = "device_token")
    private String deviceToken;

    public User(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public void changeDeviceToken(String token){
        this.deviceToken = token;
    }


}
