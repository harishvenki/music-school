package com.music.school.repository;

import com.music.school.entity.CourseMasterDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMasterDetailsRepository extends CrudRepository<CourseMasterDetailsEntity, Integer> {

    CourseMasterDetailsEntity findByName(String name);

    List<CourseMasterDetailsEntity> findAllByOrderByNameAsc();
}
