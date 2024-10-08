package com.music.school.repository;

import com.music.school.entity.StudentMasterDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentMasterDetailsRepository extends CrudRepository<StudentMasterDetailsEntity, Integer> {

    StudentMasterDetailsEntity findByUserId(@Param("userId") Integer userId);

    StudentMasterDetailsEntity findByStudentId(@Param("studentId") Integer studentId);

    List<StudentMasterDetailsEntity> findAllByStatus(Character status);

    List<StudentMasterDetailsEntity> findAllByBatch_BatchId(Integer batchId);

}
