package com.heartape.shop.permission;

/**
 * 自定义权限异常类，继承自RuntimeException
 * 用于在程序运行时表示权限相关的异常情况
 */
public class PermissionException extends RuntimeException {
    /**
     * 构造方法，创建一个带有指定错误信息的权限异常
     * @param message 异常的详细信息，用于描述权限异常的原因
     */
    public PermissionException(String message) {
    }
}
