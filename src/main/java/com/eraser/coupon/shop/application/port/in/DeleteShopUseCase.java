package com.eraser.coupon.shop.application.port.in;


/**
 * 샵 삭제 유스케이스에 대한 인커밍 포트
 */
public interface DeleteShopUseCase {

    boolean deleteShop(DeleteShopCommand command);

}
