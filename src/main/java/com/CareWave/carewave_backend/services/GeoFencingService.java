package com.CareWave.carewave_backend.services;

import org.springframework.stereotype.Service;

@Service
public class GeoFencingService {

    private static final double EARTH_RADIUS = 6371;

    public boolean isWithinRadius(double userLat, double userLon,
                                  double targetLat, double targetLon,
                                  double radiusKm) {

        double dLat = Math.toRadians(targetLat - userLat);
        double dLon = Math.toRadians(targetLon - userLon);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(targetLat))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = EARTH_RADIUS * c;

        return distance <= radiusKm;
    }
}