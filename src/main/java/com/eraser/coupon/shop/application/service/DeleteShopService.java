package com.eraser.coupon.shop.application.service;

import com.eraser.coupon.shop.application.port.in.DeleteShopCommand;
import com.eraser.coupon.shop.application.port.in.DeleteShopUseCase;
import com.eraser.coupon.shop.application.port.out.DeleteShopPort;
import com.eraser.coupon.shop.application.port.out.LoadShopPort;
import com.eraser.coupon.shop.domain.Shop;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteShopService implements DeleteShopUseCase {

    // 의존성 주입
    private final LoadShopPort loadShopPort;
    private final DeleteShopPort deleteShopPort;

    @Override
    public boolean deleteShop(DeleteShopCommand command) {

        // 삭제할 샵이 존재하는지 체크
        if (loadShopPort.loadShop(command.getId()) == null) {
            throw new IllegalStateException("삭제할 샵 정보를 찾을 수 없습니다.");
        }

        // 삭제 후 출력값 반환
        return deleteShopPort.deleteShop(command.getId());
    }
}
