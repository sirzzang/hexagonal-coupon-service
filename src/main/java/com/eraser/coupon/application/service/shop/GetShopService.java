package com.eraser.coupon.application.service.shop;

import com.eraser.coupon.application.port.in.shop.GetShopInfoQuery;
import com.eraser.coupon.application.port.out.shop.LoadShopPort;
import com.eraser.coupon.domain.shop.Shop;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GetShopService implements GetShopInfoQuery {

    // 의존성 주입
    private final LoadShopPort loadShopPort;

    @Override
    public Shop getShop(String shopId) {
        return loadShopPort.loadShop(shopId);
    }
}
