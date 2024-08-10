package com.music.school.repository;

import com.music.school.entity.UserMasterDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMasterDetailsRepository extends CrudRepository<UserMasterDetailsEntity, Integer> {
    UserMasterDetailsEntity findByUserName(String userName);
}
