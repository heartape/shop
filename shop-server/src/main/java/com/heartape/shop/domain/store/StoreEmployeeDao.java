package com.heartape.shop.domain.store;

import com.heartape.shop.store.employee.Position;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store_employee")
public class StoreEmployeeDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**用户id*/
    @Column
    private String uid;

    /**门店id*/
    @Column
    private Long storeId;

    /**职位*/
    @Column
    private Position position;

    /**姓名*/
    @Column
    private String name;

    /**年龄*/
    @Column
    private Integer age;

    /**手机号*/
    @Column
    private String phone;

    /**邮箱*/
    @Column
    private String email;

    /**头像*/
    @Column
    private String avatar;

    /**状态*/
    @Column
    private Integer status;

}
