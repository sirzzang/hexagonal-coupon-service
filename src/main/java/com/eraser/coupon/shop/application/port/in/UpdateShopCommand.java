package com.eraser.coupon.shop.application.port.in;

import com.eraser.coupon.common.SelfValidating;
import com.sun.istack.NotNull;
import lombok.Getter;

// TODO: id, isDeleted 제외 적어도 하나의 필드는 존재하도록 하는 validator
@Getter
public class UpdateShopCommand extends SelfValidating<UpdateShopCommand> {

    @NotNull
    private String id;

    private String name;

    private String description;

    private String address;

    private String phone;

    private String email;

    public UpdateShopCommand(@NotNull String id, String name, String description,
                             String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.validateSelf();
    }



}
