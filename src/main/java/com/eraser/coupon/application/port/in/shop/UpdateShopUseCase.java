package com.eraser.coupon.application.port.in.shop;

import com.eraser.coupon.common.UseCase;

/**
 * 샵 정보 수정 유스케이스에 대한 인커밍 포트
 */
public interface UpdateShopUseCase {

    boolean updateShop(UpdateShopCommand command);

}
