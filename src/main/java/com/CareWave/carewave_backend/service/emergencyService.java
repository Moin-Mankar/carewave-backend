package com.CareWave.carewave_backend.service;

import com.CareWave.carewave_backend.dto.EmergencyRequest;
import com.CareWave.carewave_backend.entity.EmergencyEvent;
import com.CareWave.carewave_backend.enums.EmergencyStatus;
import com.CareWave.carewave_backend.enums.EmergencyType;
import com.CareWave.carewave_backend.repository.EmergencyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class emergencyService {

    private final EmergencyRepository emergencyRepository;

    public emergencyService(EmergencyRepository emergencyRepository) {
        this.emergencyRepository = emergencyRepository;
    }

    public EmergencyEvent createEmergencyEvent(EmergencyRequest request){

        EmergencyEvent event = new EmergencyEvent();

        event.setEmergencyStatus(EmergencyStatus.PENDING);

        event.setUserId(request.getUserId());

        if(request.getEmergencyType()==null){
            event.setEmergencyType(EmergencyType.OTHER);
        }else {
            event.setEmergencyType(request.getEmergencyType());
        }

        event.setLongitude(request.getLongitude());
        event.setLatitude(request.getLatitude());

        LocalDateTime now = LocalDateTime.now();
        event.setCancelWindowExpiresAt(now.plusSeconds(10));

        return emergencyRepository.save(event);
    }
}
