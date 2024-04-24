package com.foodPlanet.constant;

public enum ReservationType {
    INDIVIDUAL("개인"),
    GROUP("그룹"),
    CORPORATE("기업");

    private final String description;

    ReservationType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
