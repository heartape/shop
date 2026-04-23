package com.heartape.shop.domain.store;

import com.heartape.shop.permission.PermissionManager;
import com.heartape.shop.store.Store;
import com.heartape.shop.store.StoreService;
import com.heartape.shop.store.employee.StoreEmployeeUpdateInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController("/store/employee")
public class StoreEmployeeController {

    private final PermissionManager permissionManager;

    @PutMapping("/employee")
    public void employee(StoreEmployeeUpdateInfo info) {
        Employee employee1 = new Employee(1L);
        permissionManager.validate(new Employee(info.getId()), new Employee(1L));
    }

}
