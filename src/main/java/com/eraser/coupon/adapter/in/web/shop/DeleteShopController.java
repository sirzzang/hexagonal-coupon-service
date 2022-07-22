package com.eraser.coupon.adapter.in.web.shop;

import com.eraser.coupon.application.port.in.shop.DeleteShopCommand;
import com.eraser.coupon.application.port.in.shop.DeleteShopUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class DeleteShopController {

    private final DeleteShopUseCase deleteShopUseCase;

    @PostMapping("/shops/{shopId}/delete")
    private ResponseEntity<?> deleteShop(@PathVariable(value = "shopId") String shopId) {

        // 유스케이스 입력 모델 매핑
        DeleteShopCommand command = new DeleteShopCommand(shopId);

        // 유스케이스 호출
        deleteShopUseCase.deleteShop(command);

        // TODO: 반환 응답 구체화
        return ResponseEntity.ok().body("Shop successfully deleted.");

    }

    /**
     * TODO: shopId uuid 형식에 맞는지 검증
     * - annotation
     * - validator
     */
}
