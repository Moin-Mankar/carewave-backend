package com.CareWave.carewave_backend.controllers;

import com.CareWave.carewave_backend.services.GeoFencingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/geo")
public class GeoFencingController {

    @Autowired
    private GeoFencingService geoFencingService;

    @GetMapping("/check")
    public boolean checkGeoFence(
            @RequestParam double userLat,
            @RequestParam double userLon,
            @RequestParam double targetLat,
            @RequestParam double targetLon,
            @RequestParam double radiusKm
    ) {
        return geoFencingService.isWithinRadius(
                userLat, userLon, targetLat, targetLon, radiusKm
        );
    }
}