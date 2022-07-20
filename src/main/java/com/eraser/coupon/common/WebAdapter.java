package com.eraser.coupon.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface WebAdapter {

    // TODO: 무슨 목적의 어노테이션인가

    @AliasFor(annotation = Component.class)
    String value() default "";
}
