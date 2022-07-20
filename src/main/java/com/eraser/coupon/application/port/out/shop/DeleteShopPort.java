package com.eraser.coupon.application.port.out.shop;


/**
 * 샵 삭제용 아웃고잉(데이터베이스) 어댑터 포트
 */
public interface DeleteShopPort {

    boolean deleteShop(String shopId);

}
