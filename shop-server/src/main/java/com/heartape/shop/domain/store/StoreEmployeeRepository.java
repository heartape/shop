package com.heartape.shop.domain.store;

import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface StoreEmployeeRepository extends
        JpaRepository<StoreEmployeeDao, Long>,
        QuerydslPredicateExecutor<StoreEmployeeDao>,
        QuerydslBinderCustomizer<QStoreEmployeeDao> {

    @Override
    default void customize(QuerydslBindings bindings, QStoreEmployeeDao storeEmployeeDao) {
        // 自定义绑定规则
        bindings.bind(storeEmployeeDao.name).first(StringExpression::containsIgnoreCase);
        // bindings.bind(storeEmployeeDao.age).first(NumberExpression::goe);

        // 排除某些字段不被查询
        // bindings.excluding(storeEmployeeDao.status);
    }

    default void update(JPAQueryFactory queryFactory, StoreEmployeeDao storeEmployeeDao) {
        QStoreEmployeeDao qStoreEmployeeDao = QStoreEmployeeDao.storeEmployeeDao;
        queryFactory.update(qStoreEmployeeDao)
                .set(qStoreEmployeeDao.name, storeEmployeeDao.getName())
                .where(qStoreEmployeeDao.uid.eq(storeEmployeeDao.getUid()).and(qStoreEmployeeDao.status.gt(0)))
                .execute();
    }

}
