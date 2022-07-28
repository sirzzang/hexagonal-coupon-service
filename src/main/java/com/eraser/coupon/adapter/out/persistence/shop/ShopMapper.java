package com.eraser.coupon.adapter.out.persistence.shop;

import com.eraser.coupon.domain.shop.Shop;
import org.springframework.stereotype.Component;

@Component
class ShopMapper {

    Shop toDomainEntity(ShopJpaEntity shopJpaEntity) {
        return new Shop(
                shopJpaEntity.getId(),
                shopJpaEntity.getName(),
                shopJpaEntity.getDescription(),
                shopJpaEntity.getAddress(),
                shopJpaEntity.getPhone(),
                shopJpaEntity.getEmail()
        );
    }

    ShopJpaEntity toJpaEntity(Shop shop) {
        return new ShopJpaEntity(
                shop.getId() == null ? null : shop.getId(),
                shop.getName(),
                shop.getDescription(),
                shop.getAddress(),
                shop.getPhone(),
                shop.getEmail(),
                shop.isDeleted() // boolean getter naming
        );
    }
}
