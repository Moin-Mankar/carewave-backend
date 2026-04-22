package com.CareWave.carewave_backend.service;
import java.util.HashMap;
import java.util.Map;
import com.CareWave.carewave_backend.entity.Geofence;

import org.springframework.stereotype.Service;

@Service
public class services {
    private Map<String, Geofence> geofenceMap = new HashMap<>();
    public void saveGeofence(Geofence g) {
        geofenceMap.put(g.getUserId(), g);
    }

    public Geofence getGeofence(String userId) {
        return geofenceMap.get(userId);
    }
    public boolean isWithinRadius(double userLat, double userLon,
                                  double centerLat, double centerLon,
                                  double radiusKm) {

        double earthRadius = 6371;

        double dLat = Math.toRadians(centerLat - userLat);
        double dLon = Math.toRadians(centerLon - userLon);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(centerLat))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = earthRadius * c;

        return distance <= radiusKm;
    }
}
