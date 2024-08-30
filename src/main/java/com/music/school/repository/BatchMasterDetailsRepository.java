package com.music.school.repository;

import com.music.school.entity.BatchMasterDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchMasterDetailsRepository extends CrudRepository<BatchMasterDetailsEntity, Integer> {
    List<BatchMasterDetailsEntity> findAllByOrderByNameAsc();
}
