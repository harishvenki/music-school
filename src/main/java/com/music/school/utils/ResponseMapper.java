package com.music.school.utils;

import com.music.school.entity.CompetitionMasterDetailsEntity;
import com.music.school.response.CompetitionResponseDTO;

import java.util.List;

public class ResponseMapper {
    public static CompetitionResponseDTO mapCompetitionMasterDetailsEntity(List<CompetitionMasterDetailsEntity> competitionMasterDetailsEntities) {
        List<CompetitionResponseDTO.Competition> competitions = competitionMasterDetailsEntities.stream().map(competitionMasterDetailsEntity -> {
            return CompetitionResponseDTO.Competition.builder()
                    .competitionId(competitionMasterDetailsEntity.getCompetitionId())
                    .title(competitionMasterDetailsEntity.getTitle())
                    .startDate(competitionMasterDetailsEntity.getStartDate())
                    .endDate(competitionMasterDetailsEntity.getEndDate())
                    .course(competitionMasterDetailsEntity.getCourse())
                    .audioFiles(competitionMasterDetailsEntity.getAudioFiles())
                    .videoFiles(competitionMasterDetailsEntity.getVideoFiles())
                    .descriptionText(competitionMasterDetailsEntity.getDescriptionText())
                    .image(competitionMasterDetailsEntity.getImage())
                    .status(competitionMasterDetailsEntity.getStatus())
                    .build();
        }).toList();
        return CompetitionResponseDTO.builder().competitions(competitions).build();
    }
}
