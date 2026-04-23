package com.heartape.shop.permission;

/**
 * 权限验证器接口，用于验证用户对特定资源的访问权限
 * @param <T> 资源类型，必须继承自Resource
 * @param <U> 用户类型，必须继承自Owner
 */
public interface PermissionValidator<T extends Resource, U extends Owner> {

    /**
     * 获取权限验证器的标志
     * @return 权限验证器的标志字符串
     */
    String resourceFlag();

    /**
     * 获取权限验证器的标志
     * @return 权限验证器的标志字符串
     */
    String ownerFlag();

    /**
     * 验证权限,如果用户没有权限，抛出异常
     * @param resource 权限
     * @param user 用户
     */
    void validate(T resource, U user);
}
