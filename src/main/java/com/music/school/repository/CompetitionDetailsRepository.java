package com.music.school.repository;

import com.music.school.entity.CompetitionDetailsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompetitionDetailsRepository extends CrudRepository<CompetitionDetailsEntity, Integer> {
    Optional<CompetitionDetailsEntity> findByCompetition_CompetitionIdAndStudent_StudentId(Integer competitionId, Integer studentId);
}
