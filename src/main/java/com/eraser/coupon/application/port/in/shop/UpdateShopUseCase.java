package com.eraser.coupon.application.port.in.shop;

import com.eraser.coupon.domain.shop.Shop;

/**
 * 샵 정보 수정 유스케이스에 대한 인커밍 포트
 */
public interface UpdateShopUseCase {

    // TODO: Shop 객체를 전부 반환할 필요가 있을지 고민해 보기
    boolean updateShop(UpdateShopCommand command);

}
