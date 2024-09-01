package com.music.school.repository;

import com.music.school.entity.UserMasterDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMasterDetailsRepository extends CrudRepository<UserMasterDetailsEntity, Integer> {
    UserMasterDetailsEntity findByUserName(String userName);

    List<UserMasterDetailsEntity> findAllByType(String type);

    UserMasterDetailsEntity findByUserId(Integer userId);
}
