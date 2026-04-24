package com.CareWave.carewave_backend.repository;

import com.CareWave.carewave_backend.entity.EmergencyEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmergencyRepository extends JpaRepository<EmergencyEvent, UUID> {
}