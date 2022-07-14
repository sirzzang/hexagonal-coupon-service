package com.eraser.coupon.shop.application.service;

import com.eraser.coupon.shop.application.port.in.CreateShopCommand;
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
    public Shop createShop(CreateShopCommand command) {

        // TODO: 존재하는 샵인지 체크: 사업자 등록번호?
//        if (loadShopPort.loadShop(command.getId()) != null) {
//            throw new IllegalStateException("Shop already exists."); // TODO: BusinessException
//        }

        // 샵 생성 후 출력값 반환
        return createShopPort.createShop(Shop.openShop(command));
    }
}
