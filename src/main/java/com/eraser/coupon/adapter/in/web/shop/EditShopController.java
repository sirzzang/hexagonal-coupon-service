package com.eraser.coupon.adapter.in.web.shop;

import com.eraser.coupon.application.port.in.shop.UpdateShopCommand;
import com.eraser.coupon.application.port.in.shop.UpdateShopUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class EditShopController {

    private final UpdateShopUseCase updateShopUseCase;

    @PostMapping("/shops/{shopId}/update")
    private ResponseEntity<?> editShop(
            @PathVariable(value = "shopId") Long shopId,
            @RequestBody UpdateShopDto updateShopDto
    ) {

        // 유스케이스 입력 모델 매핑
        UpdateShopCommand command = new UpdateShopCommand(
                shopId,
                updateShopDto.getName(),
                updateShopDto.getDescription(),
                updateShopDto.getAddress(),
                updateShopDto.getPhone(),
                updateShopDto.getEmail()
        );

        // 유스케이스 호출
        updateShopUseCase.updateShop(command);

            return ResponseEntity.ok().body("샵 " + shopId + " 정보가 수정되었습니다.");
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private class UpdateShopDto {

        private String name;
        private String description;
        private String address;
        private String phone;
        private String email;

    }

    /**
     * TODO: 입력모델 id 검증
     * - shopId uuid 형식 맞는지 annotation, validator 이용해 검증
     */

}
