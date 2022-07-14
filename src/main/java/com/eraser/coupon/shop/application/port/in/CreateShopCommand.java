package com.eraser.coupon.shop.application.port.in;

import com.eraser.coupon.common.SelfValidating;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateShopCommand extends SelfValidating<CreateShopCommand> {

    private String id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private String address;

    @NotNull
    private String phone;

    private String email;

    public CreateShopCommand(String id, @NotNull String name, String description,
                             @NotNull String address, @NotNull String phone, String email) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.validateSelf();
    }
}
