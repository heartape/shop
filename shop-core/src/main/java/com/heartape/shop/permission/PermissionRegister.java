package com.heartape.shop.permission;

/**
 * 权限注册器接口，用于注册权限验证器和验证资源访问权限
 *
 * @param <T> 资源类型，必须继承自Resource
 * @param <U> 所有者类型，必须继承自Owner
 */
public interface PermissionRegister<T extends Resource, U extends Owner> {

    /**
     * 注册权限验证器
     *
     * @param resource 需要访问的资源
     * @param owner 请求访问的用户
     * @return 注册结果，1有权限,0无权限
     */
    int register(T resource, U owner);

    /**
     * 验证用户对特定资源的访问权限
     *
     * @param resource 需要访问的资源
     * @param owner 请求访问的用户
     * @return 验证结果，1有权限,0无权限,-1未注册
     */
    int validate(T resource, U owner);

}
