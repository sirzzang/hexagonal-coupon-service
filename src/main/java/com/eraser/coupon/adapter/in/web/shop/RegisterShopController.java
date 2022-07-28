package com.eraser.coupon.adapter.in.web.shop;

import com.eraser.coupon.adapter.in.web.shop.CreateShopDto;
import com.eraser.coupon.application.port.in.shop.CreateShopCommand;
import com.eraser.coupon.application.port.in.shop.CreateShopUseCase;
import com.eraser.coupon.domain.shop.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class RegisterShopController {

    private final CreateShopUseCase createShopUseCase;

    @PostMapping("/shops")
    private ResponseEntity<?> registerShop(@RequestBody CreateShopDto createShopDto) {

        // 유스케이스 입력 모델 매핑
        CreateShopCommand command = new CreateShopCommand(
                createShopDto.getName(),
                createShopDto.getDescription(),
                createShopDto.getAddress(),
                createShopDto.getPhone(),
                createShopDto.getEmail()
        );

        // 유스케이스 호출
        Long shopId = createShopUseCase.createShop(command);

        // 생성된 샵 id 반환
        return ResponseEntity.ok().body(shopId);
    }

}
