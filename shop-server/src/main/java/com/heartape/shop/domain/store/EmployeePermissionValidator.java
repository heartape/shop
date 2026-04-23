package com.heartape.shop.domain.store;

import com.heartape.shop.permission.*;

/**
 * 员工数据权限验证器
 */
public class EmployeePermissionValidator extends AbstractPermissionValidator<Employee, Employee> {

    private static final String RESOURCE_FLAG = Employee.FLAG;
    private static final String OWNER_FLAG = Employee.FLAG;

    public EmployeePermissionValidator(MemoryEmployeePermissionRegister permissionManager) {
        init(permissionManager);
    }

    @Override
    public String resourceFlag() {
        return RESOURCE_FLAG;
    }

    @Override
    public String ownerFlag() {
        return OWNER_FLAG;
    }


    static class MemoryEmployeePermissionRegister extends AbstractMemoryPermissionRegister<Employee, Employee> {

        @Override
        protected boolean find(Employee resource, Employee owner) {
            // todo:更改为数据验证接口
            return true;
        }
    }

}
