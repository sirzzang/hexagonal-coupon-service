package com.eraser.coupon.domain.shop;

import com.eraser.coupon.application.port.in.shop.CreateShopCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shop {

    /**
     * 샵 식별자
     */
    private Long id;

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
    private boolean isDeleted; // getter naming

    public Shop() {}

    public Shop(String name, String description, String address, String phone, String email) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Shop(Long id, String name, String description, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Shop(Long id, String name, String description, String address, String phone, String email, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.isDeleted = isDeleted;
    }


    // 샵 생성을 위한 도메인 엔티티
    public static Shop newShop(CreateShopCommand command) {

        Shop shop = new Shop(
                command.getName(),
                command.getDescription(),
                command.getAddress(),
                command.getPhone(),
                command.getEmail());

        // 샵 생성 시 삭제 여부는 false
        shop.setDeleted(false);

        return shop;
    }

//    // 샵 업데이트를 위한 도메인 엔티티
//    // TODO: null인 속성
//    public static Shop existingShop(UpdateShopCommand command) {
//
//        return new Shop(
//                command.getName(),
//                command.getDescription(),
//                command.getAddress(),
//                command.getPhone(),
//                command.getEmail()
//        );
//
//    }

}
