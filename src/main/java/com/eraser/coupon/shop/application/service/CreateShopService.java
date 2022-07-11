package com.eraser.coupon.shop.application.service;

import com.eraser.coupon.shop.application.port.in.CreateShopUseCase;
import com.eraser.coupon.shop.application.port.out.CreateShopPort;
import com.eraser.coupon.shop.application.port.out.LoadShopPort;
import com.eraser.coupon.shop.domain.Shop;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateShopService implements CreateShopUseCase {

    // 의존성 주입
    private final LoadShopPort loadShopPort;
    private final CreateShopPort createShopPort;

    @Override
    public Shop createShop(Shop shop) {

        // 존재하는 샵인지 체크
        Shop foundShop = loadShopPort.loadShop(shop.getId());
        if (foundShop != null) {
            throw new IllegalStateException("Shop already exists."); // TODO: BusinessException
        }

        // 샵 저장 후 출력값 반환
        return createShopPort.createShop(shop);
    }
}
