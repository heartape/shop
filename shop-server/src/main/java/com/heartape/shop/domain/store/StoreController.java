package com.heartape.shop.domain.store;

import com.heartape.shop.store.Store;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/store")
public class StoreController {

    @GetMapping("/info")
    public Store info() {
        return new Store();
    }

}
