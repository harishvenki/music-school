package com.music.school.repository;

import com.music.school.entity.StudentMasterDetailsEntity;
import com.music.school.entity.TeacherMasterDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMasterDetailsRepository extends CrudRepository<TeacherMasterDetailsEntity, Integer> {
    TeacherMasterDetailsEntity findByUserId(@Param("userId") Integer userId);
}
