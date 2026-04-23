package com.heartape.shop.store.employee;

/**
 * @author heartape
 * 门店员工服务
 */
public interface StoreEmployeeService {

    /**
     * 添加加盟商
     * @param storeEmployeeCreateInfo 员工信息
     */
    void franchisee(StoreEmployeeCreateInfo storeEmployeeCreateInfo);

    /**
     * 添加店长
     * @param storeEmployeeCreateInfo 员工信息
     */
    void manager(StoreEmployeeCreateInfo storeEmployeeCreateInfo);

    /**
     * 添加员工
     * @param storeEmployeeCreateInfo 员工信息
     */
    void staff(StoreEmployeeCreateInfo storeEmployeeCreateInfo);

    /**
     * 查询员工信息
     * @param id 员工id
     * @return 员工信息
     */
    StoreEmployee info(Long id);

    /**
     * 更新员工信息
     * @param storeEmployeeUpdateInfo 员工信息
     */
    void update(StoreEmployeeUpdateInfo storeEmployeeUpdateInfo);

    /**
     * 更换员工手机号
     * 需要确保手机号经过验证码等方式的校验
     * @param phone 新手机号
     */
    void updatePhone(Long id, String phone);

    /**
     * 员工更换门店
     * @param id 员工id
     * @param storeId 门店id
     */
    void updateStore(Long id, Long storeId);

    /**
     * 删除员工
     * @param id 员工id
     */
    void delete(Long id);
}
