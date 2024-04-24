package com.foodPlanet.constant;

public enum ReservationStatus {
    CONFIRMED("확정"),
    CANCELLED("취소"),
    PENDING("대기 중");

    private final String description;

    ReservationStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
