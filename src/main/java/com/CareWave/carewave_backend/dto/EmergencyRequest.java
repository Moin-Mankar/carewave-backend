package com.CareWave.carewave_backend.dto;

import com.CareWave.carewave_backend.enums.EmergencyType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EmergencyRequest {
    private UUID userId;
    private Double latitude;
    private Double longitude;
    private EmergencyType emergencyType;
}
