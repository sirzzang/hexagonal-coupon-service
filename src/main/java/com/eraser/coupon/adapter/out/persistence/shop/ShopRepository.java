package com.eraser.coupon.adapter.out.persistence.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<ShopJpaEntity, Long> {
}
