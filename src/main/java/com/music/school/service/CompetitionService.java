package com.music.school.service;

import com.music.school.entity.CompetitionMasterDetailsEntity;
import com.music.school.response.CompetitionResponseDTO;
import org.springframework.stereotype.Service;


@Service
public interface CompetitionService {
    CompetitionResponseDTO getCompetition(Integer competitionId);
    CompetitionMasterDetailsEntity createCompetition(CompetitionMasterDetailsEntity competition);
    CompetitionMasterDetailsEntity updateCompetition(Integer competitionId, CompetitionMasterDetailsEntity competitionDetails);
    boolean deleteCompetition(Integer competitionId);
}
