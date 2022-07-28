package com.eraser.coupon.application.service.shop;

import com.eraser.coupon.application.port.in.shop.CreateShopCommand;
import com.eraser.coupon.application.port.out.shop.CreateShopPort;
import com.eraser.coupon.application.port.in.shop.CreateShopUseCase;
import com.eraser.coupon.application.port.out.shop.LoadShopPort;
import com.eraser.coupon.domain.shop.Shop;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class CreateShopService implements CreateShopUseCase {

    // 의존성 주입
    private final LoadShopPort loadShopPort;
    private final CreateShopPort createShopPort;

    @Override
    public Long createShop(CreateShopCommand command) {

        // TODO: 존재하는 샵인지 체크: 사업자 등록번호?
//        if (loadShopPort.loadShop(command.getId()) != null) {
//            throw new IllegalStateException("Shop already exists."); // TODO: BusinessException
//        }

        // 샵 생성 후 샵 id 반환
        Shop shop = createShopPort.createShop(Shop.newShop(command));
        return shop.getId();
    }
}
