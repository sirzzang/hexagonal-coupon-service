package com.eraser.coupon.shop.application.port.in;

import com.eraser.coupon.shop.domain.Shop;

/**
 * 샵 생성 유스케이스에 대한 인커밍 포트
 */
public interface CreateShopUseCase {

    Shop createShop(CreateShopCommand command);
}
