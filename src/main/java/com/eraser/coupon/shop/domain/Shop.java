package com.eraser.coupon.shop.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class Shop {

    /**
     * Unique ID of a shop
     */
    private final String id;

    /**
     * Name of a shop
     */
    private String name;

    /**
     * Description of a shop
     */
    private String description;

    /**
     * Address of a shop
     */
    private String address;

    /**
     * Phone number of a shop
     */
    private String phone;

    /**
     * Fax number of a shop
     */
    private String fax;

    /**
     * Email of a shop
     */
    private String email;

    /**
     * Whether a shop is deleted
     */
    private boolean isDeleted;
}
