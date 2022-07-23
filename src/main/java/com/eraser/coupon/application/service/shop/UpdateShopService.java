package com.eraser.coupon.application.service.shop;

import com.eraser.coupon.application.port.in.shop.UpdateShopCommand;
import com.eraser.coupon.application.port.in.shop.UpdateShopUseCase;
import com.eraser.coupon.application.port.out.shop.LoadShopPort;
import com.eraser.coupon.application.port.out.shop.UpdateShopPort;
import com.eraser.coupon.domain.shop.Shop;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class UpdateShopService implements UpdateShopUseCase {

    // 의존성 주입
    private final LoadShopPort loadShopPort;
    private final UpdateShopPort updateShopPort;

    @Override
    public boolean updateShop(UpdateShopCommand command) {

        // 비즈니스 규칙 검증
        if (loadShopPort.loadShop(command.getId()) == null) {
            throw new IllegalStateException("존재하지 않는 샵입니다.");
        }

        // 샵 업데이트 후
        updateShopPort.updateShop(Shop.existingShop(command));

        /**
         * TODO: 샵 정상 업데이트 여부 확인 방법
         * - 제대로 업데이트되었는지 확인해야 하지 않을까
         * - Shop 도메인 객체 equals 재정의?
         */
        return true;
    }
}
