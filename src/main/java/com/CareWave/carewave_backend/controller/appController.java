package com.CareWave.carewave_backend.controller;

import com.CareWave.carewave_backend.entity.Geofence;
import com.CareWave.carewave_backend.service.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class appController {

    @Autowired
    private services services;

    // 🔹 1. Create Geofence
    @PostMapping("/geofence")
    public String createGeofence(
            @RequestParam String userId,
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam double radius) {

        Geofence g = new Geofence(userId, lat, lon, radius);
        services.saveGeofence(g);

        return "Geofence created";
    }

    // 🔹 2. Location Update (MAIN FEATURE)
    @PostMapping("/location-update")
    public String updateLocation(
            @RequestParam String userId,
            @RequestParam double lat,
            @RequestParam double lon) {

        Geofence g = services.getGeofence(userId);

        if (g == null) return "No geofence";

        boolean inside = services.isWithinRadius(
                lat, lon,
                g.getCenterLat(),
                g.getCenterLon(),
                g.getRadius()
        );

        String newState = inside ? "INSIDE" : "OUTSIDE";
        String oldState = g.getState();

        if (!newState.equals(oldState)) {
            g.setState(newState);
            return "State changed: " + oldState + " → " + newState;
        }

        return "No change: " + newState;
    }
}