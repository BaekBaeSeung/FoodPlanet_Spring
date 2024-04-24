package com.foodPlanet.constant;

public enum AlarmStatus {
    READ("읽음"),
    UNREAD("안 읽음");

    private final String status;

    AlarmStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

