package com.eraser.coupon.application.port.out.shop;

import com.eraser.coupon.domain.shop.Shop;

/**
 * 샵 생성용 아웃고잉(데이터베이스) 어댑터 포트
 */
public interface CreateShopPort {

    Long createShop(Shop shop);
}
