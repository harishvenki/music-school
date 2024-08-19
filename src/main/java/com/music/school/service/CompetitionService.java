package com.music.school.service;

import com.music.school.entity.CompetitionDetailsEntity;
import com.music.school.entity.CompetitionMasterDetailsEntity;
import com.music.school.request.CompetitionDetailsDTO;
import com.music.school.response.CompetitionDetailsByIdResponseDTO;
import com.music.school.response.CompetitionDetailsRequestDTO;
import com.music.school.response.CompetitionResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CompetitionService {
    CompetitionResponseDTO getCompetition(Integer competitionId, String status, Integer userId);

    CompetitionMasterDetailsEntity createCompetition(CompetitionDetailsRequestDTO competition);

    CompetitionMasterDetailsEntity updateCompetition(Integer competitionId, CompetitionResponseDTO.Competition competition);

    boolean deleteCompetition(Integer competitionId);

    CompetitionDetailsEntity getCompetitionDetailsByCompetitionIdAndStudentId(Integer competitionId, Integer studentId);

    List<CompetitionDetailsByIdResponseDTO> getCompetitionDetailsByCompetitionId(Integer competitionId);

    CompetitionDetailsEntity createCompetitionDetails(CompetitionDetailsDTO competitionDetailsDTO);

    CompetitionDetailsEntity updateCompetitionDetails(CompetitionDetailsDTO competitionDetailsDTO);
}
