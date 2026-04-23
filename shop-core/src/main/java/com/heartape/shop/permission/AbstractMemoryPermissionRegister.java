package com.heartape.shop.permission;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * 内存权限管理器
 * @param <T>
 * @param <U>
 */
@AllArgsConstructor
public abstract class AbstractMemoryPermissionRegister<T extends Resource, U extends Owner> implements PermissionRegister<T, U> {

    private final Map<Long, Map<Long, Integer>> permissionMap = new HashMap<>();

    /**
     * 用于查找Resource是否属于Owner
     */
    protected abstract boolean find(T resource, U owner);

    @Override
    public final int register(@NonNull T resource, @NonNull U owner) {
        Long resourceId = resource.getId();
        Long uid = owner.getId();
        Map<Long, Integer> map = permissionMap.computeIfAbsent(resourceId, k -> new HashMap<>());
        if (!map.isEmpty()){
            Integer status = map.get(uid);
            if (status != null){
                return status;
            }
        }
        boolean find = find(resource, owner);

        if (find){
            map.put(uid, 1);
            return 1;
        }else {
            map.put(uid, 0);
            return 0;
        }
    }

    @Override
    public final int validate(@NonNull T resource, @NonNull U owner) {
        Map<Long, Integer> map = permissionMap.get(resource.getId());
        if (map == null || map.isEmpty()){
            return -1;
        }
        return map.get(owner.getId());
    }
}
