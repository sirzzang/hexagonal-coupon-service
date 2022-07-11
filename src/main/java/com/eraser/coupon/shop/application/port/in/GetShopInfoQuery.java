package com.eraser.coupon.shop.application.port.in;

import com.eraser.coupon.shop.domain.Shop;

/**
 * 읽기 전용 유스케이스(샵 조회)에 대한 인커밍 포트
 */
public interface GetShopInfoQuery {

    Shop getShop(String shopId);
}
