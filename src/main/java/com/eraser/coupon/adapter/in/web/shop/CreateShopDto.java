package com.eraser.coupon.adapter.in.web.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
/**
 * nested exception is org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class com.eraser.coupon.adapter.in.web.shop.RegisterShopController$CreateShopDto]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.eraser.coupon.adapter.in.web.shop.RegisterShopController$CreateShopDto`: non-static inner classes like this can only by instantiated using default, no-argument constructor
 */
class CreateShopDto {

    private String name;
    private String description;
    private String address;
    private String phone;
    private String email;

}
