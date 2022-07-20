package com.eraser.coupon.adapter.in;

import com.eraser.coupon.application.port.in.shop.*;
import com.eraser.coupon.common.WebAdapter;
import com.eraser.coupon.domain.shop.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ShopController {

    // TODO: responsebody 에러 핸들링
    // TODO: 책과 달리 한 컨트롤러에 모든 서비스에 대한 웹 어댑터 다 작성했는데?

    private final CreateShopUseCase createShopUseCase;
    private final GetShopInfoQuery getShopInfoQuery;
    private final UpdateShopUseCase updateShopUseCase;
    private final DeleteShopUseCase deleteShopUseCase;

    @GetMapping("/shops/{shopId}")
    public ResponseEntity<Shop> getShop(@PathVariable(value = "shopId") String shopId) {
        Shop shop = getShopInfoQuery.getShop(shopId);
        return ResponseEntity.ok().body(shop);
    }

    //  -> 이 때문에 컨트롤러만의 모델?

    /**
     * TODO: 컨트롤러 DTO 없이 바로 도메인으로 접근해도 되는지?
     * - 책에서 컨트롤러만의 모델을 두라고 했던 것이 이런 맥락에서의 컨트롤러 DTO인가?
     * - Hexagonal-Architecture-DDD 소스코드에서는 컨트롤러에서 바로 Order 도메인으로 접근함
     */
    @PostMapping("/shops")
    public ResponseEntity<Shop> registerShop(@RequestBody Shop shop) {
        CreateShopCommand command = new CreateShopCommand(
                shop.getName(), shop.getDescription(), shop.getAddress(), shop.getPhone(), shop.getEmail()
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
