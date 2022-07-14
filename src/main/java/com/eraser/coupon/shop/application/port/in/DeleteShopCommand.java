package com.eraser.coupon.shop.application.port.in;

import com.eraser.coupon.common.SelfValidating;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class DeleteShopCommand extends SelfValidating<DeleteShopCommand> {

    @NotNull
    String id;

    public DeleteShopCommand(@NotNull String id) {
        this.id = id;
        this.validateSelf();
    }
}
