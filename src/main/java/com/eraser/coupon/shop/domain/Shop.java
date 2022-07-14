package com.eraser.coupon.shop.domain;

import com.eraser.coupon.shop.application.port.in.CreateShopCommand;
import com.eraser.coupon.shop.application.port.in.DeleteShopCommand;
import com.eraser.coupon.shop.application.port.in.UpdateShopCommand;
import lombok.*;


@Getter
@Builder
public class Shop {

    /**
     * 샵 식별자
     */
    private String id;

    /**
     * 샵 이름
     */
    private String name;

    /**
     * 샵 설명
     */
    private String description;

    /**
     * 샵 주소
     */
    private String address;

    /**
     * 샵 전화번호
     */
    private String phone;

    /**
     * 샵 이메일
     */
    private String email;

    /**
     * 샵 삭제 여부
     */
    private boolean isDeleted;

//    public static Shop of(String id, String name, String description, String address,
//                              String phone, String email, boolean isDeleted) {
//        return new Shop(id, name, address, description, phone, email, isDeleted);
//    }


    // 샵 생성을 위한 도메인 엔티티
    public static Shop newShop(CreateShopCommand command) {
        return Shop.builder()
                .id(command.getId())
                .name(command.getName())
                .description(command.getDescription())
                .address(command.getAddress())
                .phone(command.getPhone())
                .email(command.getEmail())
                .isDeleted(false) // 샵 생성 시 삭제 여부는 false
                .build();
    }

    // 샵 업데이트를 위한 도메인 엔티티
    public static Shop existingShop(UpdateShopCommand command) {
        return Shop.builder()
                .id(command.getId())
                .name(command.getName())
                .description(command.getDescription())
                .address(command.getAddress())
                .phone(command.getPhone())
                .email(command.getEmail())
                .build();
    }

}
