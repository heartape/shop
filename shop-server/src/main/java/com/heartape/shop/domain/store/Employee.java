package com.heartape.shop.domain.store;

import com.heartape.shop.permission.Owner;
import com.heartape.shop.permission.Resource;

public record Employee(Long id) implements Resource, Owner {

    public static final String FLAG = "com.heartape.shop.domain.store.Employee";

    @Override
    public String flag() {
        return FLAG;
    }

    @Override
    public Long getId() {
        return id;
    }
}
