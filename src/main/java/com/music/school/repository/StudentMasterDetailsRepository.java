package com.music.school.repository;

import com.music.school.entity.StudentMasterDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMasterDetailsRepository extends CrudRepository<StudentMasterDetailsEntity, Integer> {
}
