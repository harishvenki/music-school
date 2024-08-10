package com.music.school.repository;

import com.music.school.entity.PrizeMasterDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrizeMasterDetailsRepository extends CrudRepository<PrizeMasterDetailsEntity, Integer> {
}
