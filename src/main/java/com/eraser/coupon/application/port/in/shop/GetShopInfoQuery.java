package com.eraser.coupon.application.port.in.shop;

import com.eraser.coupon.domain.shop.Shop;

import java.util.List;

/**
 * 읽기 전용 유스케이스(샵 조회)에 대한 인커밍 포트
 */
public interface GetShopInfoQuery {

    Shop getShop(Long shopId);

//    List<String> getShopList();

}
