package com.heartape.shop.domain.warehouse;

import com.heartape.shop.logistics.Warehouse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/warehouse")
public class WarehouseController {

    @GetMapping("/info")
    public Warehouse info() {
        return new Warehouse();
    }

}
