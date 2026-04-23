package com.heartape.shop.permission;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象权限管理器类，实现了PermissionManager接口
 * 提供了权限验证器的存储和基本管理功能
 */
public class HashPermissionManager implements PermissionManager {

    /**
     * 存储权限验证器的映射表<Resource, <Owner, PermissionValidator>>
     * 键为权限验证器的标志(flag)，值为对应的权限验证器实例
     */
    private final Map<String, Map<String, PermissionValidator<?, ?>>> validators = new HashMap<>();

    /**
     * 添加一个权限验证器
     *
     * @param permissionValidator 要添加的权限验证器
     */
    @Override
    public <T extends Resource, U extends Owner> void add(PermissionValidator<T, U> permissionValidator) {
        if (permissionValidator == null) {
            throw new IllegalArgumentException("权限验证器不能为null");
        }

        validators
            .computeIfAbsent(permissionValidator.resourceFlag(), k -> new HashMap<>())
            .putIfAbsent(permissionValidator.ownerFlag(), permissionValidator);
    }

    /**
     * 验证权限入口
     *
     * @param resource 资源
     * @param user 用户
     */
    @Override
    public <T extends Resource, U extends Owner> void validate(T resource, U user) {
        if (resource == null || user == null) {
            throw new IllegalArgumentException("资源和用户不能为null");
        }

        // 获取适用于当前资源和用户类型的所有验证器
        PermissionValidator<T, U> validator = getApplicableValidators(resource, user);

        // 如果没有找到适用的验证器，抛出异常
        if (validator == null) {
            throw new PermissionException("没有找到适用于该资源和用户类型的权限验证器");
        }

        validator.validate(resource, user);
    }



    /**
     * 获取适用于指定资源和用户类型的所有权限验证器
     *
     * @param resource 资源
     * @param owner 用户
     * @return 适用的权限验证器列表
     */
    @SuppressWarnings("unchecked")
    protected <T extends Resource, U extends Owner> PermissionValidator<T, U> getApplicableValidators(T resource, U owner) {
        // 获取直接匹配的验证器
        Map<String, PermissionValidator<?, ?>> ownerMap = validators.get(resource.flag());
        if (ownerMap == null) {
            return null;
        }

        return (PermissionValidator<T, U>)ownerMap.get(owner.flag());
    }

}
