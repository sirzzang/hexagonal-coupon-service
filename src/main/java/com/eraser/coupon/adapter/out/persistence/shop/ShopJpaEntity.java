package com.eraser.coupon.adapter.out.persistence.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="shop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class ShopJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;
    private String description;

    @NotNull
    private String address;

    @NotNull
    private String phone;
    private String email;

    @NotNull
    private boolean isDeleted;
}
