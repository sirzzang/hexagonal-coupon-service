package com.eraser.coupon.adapter.in.web.shop;

import com.eraser.coupon.application.port.in.shop.GetShopInfoQuery;
import com.eraser.coupon.domain.shop.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class FindShopController {

    private final GetShopInfoQuery getShopInfoQuery;

    @GetMapping("/shops/{shopId}")
    private ResponseEntity<?> findShop(@PathVariable(value = "shopId") String shopId) {

        // 유스케이스 호출
        // TODO: 도메인 그대로 반환하면 안 됨
        Shop foundShop = getShopInfoQuery.getShop(shopId);

        return ResponseEntity.ok().body(foundShop);
    }

    /**
     * TODO: shopId uuid 형식에 맞는지 검증
     * - annotation
     * - validator
     */
}
