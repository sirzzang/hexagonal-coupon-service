package com.eraser.coupon.application.service.shop;

import com.eraser.coupon.application.port.in.shop.DeleteShopUseCase;
import com.eraser.coupon.application.port.out.shop.DeleteShopPort;
import com.eraser.coupon.application.port.out.shop.LoadShopPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class DeleteShopService implements DeleteShopUseCase {

    // 의존성 주입
    private final LoadShopPort loadShopPort;
    private final DeleteShopPort deleteShopPort;

    @Override
    public boolean deleteShop(String shopId) {

        // 삭제할 샵이 존재하는지 체크
        if (loadShopPort.loadShop(shopId) == null) {
            throw new IllegalStateException("삭제할 샵 정보를 찾을 수 없습니다.");
        }

        // 삭제 후 출력값 반환
        return deleteShopPort.deleteShop(shopId);
    }
}
