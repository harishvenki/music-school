package com.music.school.repository;

import com.music.school.entity.CompetitionMasterDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionMasterDetailsRepository extends CrudRepository<CompetitionMasterDetailsEntity, Integer> {
}
