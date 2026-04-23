package com.heartape.shop.domain.store;

import com.heartape.shop.store.employee.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StoreEmployeeServiceImpl implements StoreEmployeeService {

    private final StoreEmployeeRepository storeEmployeeRepository;

    private final StoreEmployeeIdGenerator storeEmployeeIdGenerator;

    @Override
    public void franchisee(StoreEmployeeCreateInfo storeEmployeeCreateInfo) {
        StoreEmployeeDao storeEmployeeDao = exchange(storeEmployeeCreateInfo);
        storeEmployeeDao.setPosition(Position.FRANCHISEE);
        storeEmployeeRepository.save(storeEmployeeDao);
    }

    private StoreEmployeeDao exchange(StoreEmployeeCreateInfo storeEmployeeCreateInfo) {
        return new StoreEmployeeDao(
                null,
                storeEmployeeIdGenerator.generate(),
                storeEmployeeCreateInfo.getStoreId(),
                null,
                storeEmployeeCreateInfo.getName(),
                storeEmployeeCreateInfo.getAge(),
                storeEmployeeCreateInfo.getPhone(),
                null,
                null,
                1);
    }

    @Override
    public void manager(StoreEmployeeCreateInfo storeEmployeeCreateInfo) {
        StoreEmployeeDao storeEmployeeDao = exchange(storeEmployeeCreateInfo);
        storeEmployeeDao.setPosition(Position.MANAGER);
        storeEmployeeRepository.save(storeEmployeeDao);
    }

    @Override
    public void staff(StoreEmployeeCreateInfo storeEmployeeCreateInfo) {
        StoreEmployeeDao storeEmployeeDao = exchange(storeEmployeeCreateInfo);
        storeEmployeeDao.setPosition(Position.STAFF);
        storeEmployeeRepository.save(storeEmployeeDao);
    }

    @Override
    public StoreEmployee info(Long id) {
        StoreEmployeeDao storeEmployeeDao = storeEmployeeRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return exchange(storeEmployeeDao);
    }

    private StoreEmployee exchange(StoreEmployeeDao storeEmployeeDao) {
        return StoreEmployee.builder()
                .id(storeEmployeeDao.getId())
                .uid(storeEmployeeDao.getUid())
                .storeId(storeEmployeeDao.getStoreId())
                .position(storeEmployeeDao.getPosition())
                .name(storeEmployeeDao.getName())
                .age(storeEmployeeDao.getAge())
                .phone(storeEmployeeDao.getPhone())
                .email(storeEmployeeDao.getEmail())
                .avatar(storeEmployeeDao.getAvatar())
                .build();
    }

    @Override
    public void update(StoreEmployeeUpdateInfo storeEmployeeUpdateInfo) {

    }

    @Override
    public void updatePhone(Long id, String phone) {

    }

    @Override
    public void updateStore(Long id, Long storeId) {

    }

    @Override
    public void delete(Long id) {

    }
}
