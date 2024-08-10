package com.music.school.repository;

import com.music.school.entity.CourseMasterDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMasterDetailsRepository extends CrudRepository<CourseMasterDetailsEntity, Integer> {
}
