package com.eraser.coupon.application.port.in.shop;

import com.eraser.coupon.common.SelfValidating;
import lombok.Getter;

import javax.validation.constraints.NotNull;

// TODO: id, isDeleted 제외 적어도 하나의 필드는 존재하도록 하는 validator
@Getter
public class UpdateShopCommand extends SelfValidating<UpdateShopCommand> {

    @NotNull
    private Long id;

    private String name;

    private String description;

    private String address;

    private String phone;

    private String email;

    // TODO: 생성자를 이용하는 경우, 일부 정보만 수정하고 싶을 때 command를 어떻게 생성하는 것이 좋은가? 빌더...?
    public UpdateShopCommand(
            @NotNull Long id, String name, String description,
            String address, String phone, String email
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.validateSelf();
    }



}
