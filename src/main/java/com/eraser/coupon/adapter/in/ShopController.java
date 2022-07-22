package com.eraser.coupon.adapter.in;

import com.eraser.coupon.adapter.in.dto.CreateShopDto;
import com.eraser.coupon.application.port.in.shop.*;
import com.eraser.coupon.common.WebAdapter;
import com.eraser.coupon.domain.shop.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequiredArgsConstructor
class ShopController {

    // TODO: responsebody 에러 핸들링
    // TODO: 책과 달리 한 컨트롤러에 모든 서비스에 대한 웹 어댑터 다 작성

    private final CreateShopUseCase createShopUseCase;
    private final GetShopInfoQuery getShopInfoQuery;
    private final UpdateShopUseCase updateShopUseCase;
    private final DeleteShopUseCase deleteShopUseCase;

    @GetMapping("/shops/{shopId}")
    public ResponseEntity<Shop> getShop(@PathVariable(value = "shopId") String shopId) {
        Shop shop = getShopInfoQuery.getShop(shopId);
        return ResponseEntity.ok().body(shop);
    }

    @PostMapping("/shops")
    public ResponseEntity<Shop> registerShop(@RequestBody CreateShopDto createShopDto) {
        CreateShopCommand command = new CreateShopCommand(
                createShopDto.getName(),
                createShopDto.getDescription(),
                createShopDto.getAddress(),
                createShopDto.getPhone(),
                createShopDto.getEmail()
        );

        Shop createdShop = createShopUseCase.createShop(command);

        return ResponseEntity.ok().body(createdShop);
    }

    @PostMapping("/shops/{shopId}/edit")
    public ResponseEntity<Shop> editShop(@PathVariable(value = "shopId") String shopId, @RequestBody Shop shop) {
        UpdateShopCommand command = new UpdateShopCommand(
                shopId, shop.getName(), shop.getDescription(), shop.getAddress(), shop.getPhone(), shop.getEmail()
        );

        Shop updatedShop = updateShopUseCase.updateShop(command);

        return ResponseEntity.ok().body(updatedShop);

    }

    @PostMapping("/shops/{shopId}/delete")
    public ResponseEntity<?> deleteShop(@PathVariable(value = "shopId") String shopId) {
        DeleteShopCommand command = new DeleteShopCommand(shopId);

        deleteShopUseCase.deleteShop(command);

        return ResponseEntity.ok().body("Shop successfully deleted");
    }

}
