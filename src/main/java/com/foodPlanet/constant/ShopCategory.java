package com.foodPlanet.constant;

public enum ShopCategory {
    NOTHING("-- 카테고리를 선택해주세요. --"),
    KFOOD("한식"),
    CFOOD("중식"),
    JFOOD("일식"),
    WESTERN("양식"),
    FASTFOOD("패스트푸드"),
    VEGETARIAN("채식"),
    VEGAN("비건"),
    HALAL("할랄"),
    SEAFOOD("해산물"),
    DESSERTS("디저트"),
    CAFE("카페"),
    BUFFET("뷔페"),
    BARBECUE("바베큐"),
    PUB("펍"),
    FAMILY_RESTAURANT("가족레스토랑"),
    BRUNCH("브런치"),
    FUSION("퓨전"),
    DOG_FRIENDLY("애견동반");

    private final String displayName;

    ShopCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
