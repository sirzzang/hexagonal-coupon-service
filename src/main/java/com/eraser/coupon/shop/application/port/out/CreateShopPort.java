package com.eraser.coupon.shop.application.port.out;

import com.eraser.coupon.shop.domain.Shop;

/**
 * 샵 생성용 아웃고잉(데이터베이스) 어댑터 포트
 */
public interface CreateShopPort {

    Shop createShop(Shop shop);
}
