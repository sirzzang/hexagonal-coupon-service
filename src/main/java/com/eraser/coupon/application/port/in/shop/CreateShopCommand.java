package com.eraser.coupon.application.port.in.shop;

import com.eraser.coupon.common.SelfValidating;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateShopCommand extends SelfValidating<CreateShopCommand> {

    private Long id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private String address;

    @NotNull
    private String phone;

    private String email;

    public CreateShopCommand(
            @NotNull String name, String description, @NotNull String address, @NotNull String phone, String email
    ) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.validateSelf();
    }
}
