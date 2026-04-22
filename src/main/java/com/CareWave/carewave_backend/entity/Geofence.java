package com.CareWave.carewave_backend.entity;

public class Geofence {

    private String userId;
    private double centerLat;
    private double centerLon;
    private double radius;
    private String state;

    public Geofence(String userId, double centerLat, double centerLon, double radius) {
        this.userId = userId;
        this.centerLat = centerLat;
        this.centerLon = centerLon;
        this.radius = radius;
        this.state = "UNKNOWN";
    }

    public String getUserId() {
        return userId;
    }

    public double getCenterLat() {
        return centerLat;
    }

    public double getCenterLon() {
        return centerLon;
    }

    public double getRadius() {
        return radius;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}