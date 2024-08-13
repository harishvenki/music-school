package com.music.school.repository;

import com.music.school.entity.CompetitionMasterDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionMasterDetailsRepository extends CrudRepository<CompetitionMasterDetailsEntity, Integer> {
    CompetitionMasterDetailsEntity findByCompetitionId(@Param("competitionId") Integer competitionId);

    List<CompetitionMasterDetailsEntity> findByStatus(@Param("status") String status);
}
