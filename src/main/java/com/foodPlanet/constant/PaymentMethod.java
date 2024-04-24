package com.foodPlanet.constant;

public enum PaymentMethod {
    CARD("카드"),
    CASH("현장결제");

    private final String description;

    PaymentMethod(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
