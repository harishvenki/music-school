package com.music.school.utils;

import com.music.school.entity.CompetitionDetailsEntity;
import com.music.school.entity.CompetitionMasterDetailsEntity;
import com.music.school.entity.CourseMasterDetailsEntity;
import com.music.school.repository.CompetitionDetailsRepository;
import com.music.school.repository.CourseMasterDetailsRepository;
import com.music.school.response.CompetitionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ResponseMapper {


    public static CompetitionResponseDTO mapCompetitionMasterDetailsEntity(List<CompetitionMasterDetailsEntity> competitionMasterDetailsEntities) {
        List<CompetitionResponseDTO.Competition> competitions = competitionMasterDetailsEntities.stream().map(competitionMasterDetailsEntity -> {
            return CompetitionResponseDTO.Competition.builder()
                    .competitionId(competitionMasterDetailsEntity.getCompetitionId())
                    .title(competitionMasterDetailsEntity.getTitle())
                    .startDate(competitionMasterDetailsEntity.getStartDate())
                    .endDate(competitionMasterDetailsEntity.getEndDate())
                    .courseList(competitionMasterDetailsEntity.getCourseName())
                    .audioFiles(competitionMasterDetailsEntity.getAudioFiles())
                    .videoFiles(competitionMasterDetailsEntity.getVideoFiles())
                    .shortDescription(competitionMasterDetailsEntity.getShortDescription())
                    .descriptionText(competitionMasterDetailsEntity.getDescriptionText())
                    .image(competitionMasterDetailsEntity.getImage())
                    .status(competitionMasterDetailsEntity.getStatus())
                    .build();
        }).toList();
        return CompetitionResponseDTO.builder().competitions(competitions).build();
    }
}
