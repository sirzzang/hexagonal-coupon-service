package com.eraser.coupon.application.port.in.shop;

import com.eraser.coupon.domain.shop.Shop;

/**
 * 샵 생성 유스케이스에 대한 인커밍 포트
 */
public interface CreateShopUseCase {

    // TODO: Shop 객체를 전부 반환할 필요가 있을지 고민해 보기
    String createShop(CreateShopCommand command);
}
