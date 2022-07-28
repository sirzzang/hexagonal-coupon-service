package com.eraser.coupon.application.port.in.shop;

import com.eraser.coupon.domain.shop.Shop;

/**
 * 샵 생성 유스케이스에 대한 인커밍 포트
 */
public interface CreateShopUseCase {

    Long createShop(CreateShopCommand command);
}
