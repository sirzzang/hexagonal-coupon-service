package com.eraser.coupon.adapter.out.persistence.shop;

import com.eraser.coupon.application.port.out.shop.CreateShopPort;
import com.eraser.coupon.application.port.out.shop.DeleteShopPort;
import com.eraser.coupon.application.port.out.shop.LoadShopPort;
import com.eraser.coupon.common.PersistenceAdapter;
import com.eraser.coupon.domain.shop.Shop;
import lombok.RequiredArgsConstructor;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class ShopPersistenceAdapter
        implements CreateShopPort, LoadShopPort, DeleteShopPort {

    private final ShopMapper shopMapper;
    private final ShopRepository shopRepository;


    @Override
    public Long createShop(Shop shop) {
        return shopRepository
                .save(shopMapper.toJpaEntity(shop))
                .getId();
    }

    @Override
    public void deleteShop(Long shopId) {

        // 삭제 여부 변경 대상 샵
        ShopJpaEntity shopJpaEntity = shopRepository.findById(shopId)
                .orElseThrow(() -> new IllegalArgumentException(("No shop found.")));

        // 샵 삭제
        shopJpaEntity.setDeleted(true);

    }

    @Override
    public Shop loadShop(Long id) {

        ShopJpaEntity shopJpaEntity = shopRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No shop found."));

        return shopMapper.toDomainEntity(shopJpaEntity);
    }

//    @Override
//    public List<String> loadShopIds() {
//        return null;
//    }

//    @Override
//    public Shop updateShop(Long Shop shop) {
//        return null;
//    }
}
