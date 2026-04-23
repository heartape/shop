package com.heartape.shop.permission;

/**
 * 抽象权限验证器类，实现了PermissionValidator接口
 * 这是一个泛型类，支持对任意类型的资源(T)和所有者(U)进行权限验证
 *
 * @param <T> 继承自Resource的资源类型
 * @param <U> 继承自Owner的所有者类型
 */
public abstract class AbstractPermissionValidator <T extends Resource, U extends Owner> implements PermissionValidator<T, U>{

    /**
     * 权限管理器，用于处理具体的权限验证和注册逻辑
     */
    private PermissionRegister<T, U> permissionRegister;

    protected void setPermissionManager(PermissionRegister<T, U> permissionRegister) {
        this.permissionRegister = permissionRegister;
    }

    public final void init(PermissionRegister<T, U> permissionRegister) {
        setPermissionManager(permissionRegister);
    }

    /**
     * 验证用户对资源的访问权限
     *
     * @param resource 需要验证权限的资源
     * @param owner 请求访问资源的用户
     * @throws PermissionException 当用户没有权限时抛出异常
     */
    @Override
    public void validate(T resource, U owner) {
        int validate = permissionRegister.validate(resource, owner);
        switch (validate){
            case 0:
                throw new PermissionException("没有权限");
            case 1:
                break;
            case -1:
                int register = permissionRegister.register(resource, owner);
                if (register == 0){
                    throw new PermissionException("没有权限");
                }
                break;
        }
    }
}
