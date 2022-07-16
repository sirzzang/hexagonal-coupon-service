package com.eraser.coupon.shop.domain;

import com.eraser.coupon.shop.application.port.in.CreateShopCommand;
import com.eraser.coupon.shop.application.port.in.UpdateShopCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    // 기본 생성자 접근 방지
    protected Shop() {}

    // id 없는 셍성자(영속용)
    protected Shop(String name, String description, String address, String phone, String email) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    // id 있는 생성자(영속 후 수정용)
    protected Shop(String id, String name, String description, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    // 샵 생성을 위한 도메인 엔티티
    public static Shop newShop(CreateShopCommand command) {

        Shop shop = new Shop(
                command.getName(), command.getDescription(),
                command.getAddress(), command.getPhone(), command.getEmail());
        shop.setDeleted(false); // 샵 생성 시 삭제 여부는 false
        shop.isDeleted = false;

        return shop;
    }

    // 샵 업데이트를 위한 도메인 엔티티
    // TODO: null인 속성
    public static Shop existingShop(UpdateShopCommand command) {

        return new Shop(
                command.getId(), command.getName(), command.getDescription(),
                command.getAddress(), command.getPhone(), command.getEmail()
        );

    }

}
