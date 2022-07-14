package com.eraser.coupon.shop.application.port.in;

import com.eraser.coupon.shop.domain.Shop;

/**
 * 샵 정보 수정 유스케이스에 대한 인커밍 포트
 */
public interface UpdateShopUseCase {

    Shop updateShop(UpdateShopCommand command);

}
