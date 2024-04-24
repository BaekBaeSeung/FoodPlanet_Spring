package com.foodPlanet.constant;

public enum PaymentStatus {
    COMPLETED("완료"),
    CANCELLED("취소"),
    PENDING("대기 중");

    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
