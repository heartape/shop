package com.heartape.shop.domain.product;

import com.heartape.shop.product.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/product")
public class ProductController {

    @GetMapping("/info")
    public Product info() {
        return new Product();
    }

}
