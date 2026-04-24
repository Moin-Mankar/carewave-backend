package com.CareWave.carewave_backend.entity;

import com.CareWave.carewave_backend.enums.EmergencyStatus;
import com.CareWave.carewave_backend.enums.EmergencyType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class EmergencyEvent {

    @Id
    @GeneratedValue
    private UUID emergencyId;

    @Column(nullable = false)
    private UUID userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmergencyStatus emergencyStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmergencyType emergencyType;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime resolvedAt;

    @Column(nullable = false)
    private LocalDateTime cancelWindowExpiresAt;

    private LocalDateTime activatedAt;

    private Double latitude;
    private Double  longitude;

    @PrePersist
    public void onCreate(){
        this.createdAt= LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate(){
        this.updatedAt= LocalDateTime.now();
    }

    


}
