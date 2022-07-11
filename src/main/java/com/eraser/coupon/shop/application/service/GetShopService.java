package com.eraser.coupon.shop.application.service;

import com.eraser.coupon.shop.application.port.in.GetShopInfoQuery;
import com.eraser.coupon.shop.application.port.out.LoadShopPort;
import com.eraser.coupon.shop.domain.Shop;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetShopService implements GetShopInfoQuery {

    // 의존성 주입
    private final LoadShopPort loadShopPort;

    @Override
    public Shop getShop(String shopId) {
        return loadShopPort.loadShop(shopId);
    }
}
