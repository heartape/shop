package com.heartape.shop.domain.store;

import com.heartape.shop.store.Store;
import com.heartape.shop.store.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController("/store")
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/list")
    public List<Store> list(@RequestParam String name, @RequestParam Integer page, @RequestParam Integer size) {
        return storeService.list(name, page, size);
    }

    @GetMapping("/list/manager/simple")
    public List<Store> simples(@RequestParam Long id) {
        return storeService.simples(id);
    }

    @GetMapping("/info")
    public Store info(@RequestParam Long id) {
        return storeService.info(id);
    }

}
