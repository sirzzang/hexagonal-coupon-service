package com.eraser.coupon.application.port.in.shop;


import com.eraser.coupon.common.UseCase;

/**
 * 샵 삭제 유스케이스에 대한 인커밍 포트
 */
public interface DeleteShopUseCase {

    void deleteShop(Long shopId);

}
