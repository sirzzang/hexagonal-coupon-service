package com.eraser.coupon.shop.application.service;

import com.eraser.coupon.shop.application.port.in.UpdateShopCommand;
import com.eraser.coupon.shop.application.port.in.UpdateShopUseCase;
import com.eraser.coupon.shop.application.port.out.LoadShopPort;
import com.eraser.coupon.shop.application.port.out.UpdateShopPort;
import com.eraser.coupon.shop.domain.Shop;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class UpdateShopService implements UpdateShopUseCase {

    // 의존성 주입
    private final LoadShopPort loadShopPort;
    private final UpdateShopPort updateShopPort;

    @Override
    public Shop updateShop(UpdateShopCommand command) {

        // 비즈니스 규칙 검증
        if (loadShopPort.loadShop(command.getId()) == null) {
            throw new IllegalStateException("존재하지 않는 샵입니다.");
        }

        // 샵 업데이트 후 출력값 반환
        return updateShopPort.updateShop(Shop.existingShop(command));
    }
}
