package com.foodPlanet.constant;

// 상품의 상태를 표현하는 열거형 타입
// SELL(판매중), SOLD_OUT(품절)
// NOTHING은 콤보 박스에서 선택되지 않았을 때 취할 값
public enum ProductStatus {
    NOTHING("-- 선택해 주세요. --"), SELL("판매중"), SOLD_OUT("품절") ;

    private String status ;

    ProductStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
