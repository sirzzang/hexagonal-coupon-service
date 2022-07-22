package com.eraser.coupon.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateShopDto {

    // 반드시 있어야 하는 필드에 대한 검사는 커맨드 유효성 검사에서 진행
    private String name;
    private String description;
    private String address;
    private String phone;
    private String email;

}
