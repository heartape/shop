package com.heartape.shop.permission;

/**
 * 权限管理器接口
 * 该接口用于管理权限验证器，并添加新的验证器
 */
public interface PermissionManager {

    /**
     * 添加一个权限验证器
     *
     * @param permissionValidator 要添加的权限验证器，必须与当前接口的泛型类型一致
     */
    <T extends Resource, U extends Owner>void add(PermissionValidator<T, U> permissionValidator);

    /**
     * 验证权限入口
     * @param resource 权限
     * @param user 用户
     */
    <T extends Resource, U extends Owner>void validate(T resource, U user);

}
