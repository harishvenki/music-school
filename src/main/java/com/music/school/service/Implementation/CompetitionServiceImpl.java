package com.music.school.service.Implementation;

import com.music.school.entity.CompetitionMasterDetailsEntity;
import com.music.school.exception.DataAccessException;
import com.music.school.repository.CompetitionMasterDetailsRepository;
import com.music.school.response.CompetitionResponseDTO;
import com.music.school.service.CompetitionService;
import com.music.school.utils.ResponseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

public class CompetitionServiceImpl implements CompetitionService {
    public static final Logger logger = LoggerFactory.getLogger(CompetitionService.class);

    @Autowired
    private CompetitionMasterDetailsRepository competitionMasterDetailsRepository;

    @Override
    public CompetitionResponseDTO getCompetition(Integer competitionId) {
        try {
            if (Objects.nonNull(competitionId)) {
                return competitionMasterDetailsRepository.findById(competitionId)
                        .map(entity -> ResponseMapper.mapCompetitionMasterDetailsEntity(List.of(entity)))
                        .orElseThrow(() -> new DataAccessException(String.format("No data found for competition ID: %d", competitionId), null));
            } else {
                Iterable<CompetitionMasterDetailsEntity> competitionMasterDetailsEntity = competitionMasterDetailsRepository.findAll();
                return ResponseMapper.mapCompetitionMasterDetailsEntity(StreamSupport.stream(competitionMasterDetailsEntity.spliterator(), false).toList());
            }
        } catch (Exception e) {
            logger.error("Exception occurred while fetching competition details: {}", e.getMessage(), e);
            throw new DataAccessException("Data access exception occurred while fetching competition details", e);
        }
    }


    @Override
    public CompetitionMasterDetailsEntity createCompetition(CompetitionMasterDetailsEntity competition) {
        try {
            return competitionMasterDetailsRepository.save(competition);
        } catch (Exception e) {
            logger.error("Exception occurred while creating competition: {}", e.getMessage(), e);
            throw new DataAccessException("Data access exception occurred while creating competition", e);
        }
    }

    @Override
    public CompetitionMasterDetailsEntity updateCompetition(Integer competitionId, CompetitionMasterDetailsEntity competitionDetails) {
        try {
            if (competitionMasterDetailsRepository.existsById(competitionId)) {
                competitionDetails.setCompetitionId(competitionId);
                return competitionMasterDetailsRepository.save(competitionDetails);
            }
            return null;
        } catch (Exception e) {
            logger.error("Exception occurred while updating competition ID {}: {}", competitionId, e.getMessage(), e);
            throw new DataAccessException("Data access exception occurred while updating competition", e);
        }
    }

    @Override
    public boolean deleteCompetition(Integer competitionId) {
        try {
            if (competitionMasterDetailsRepository.existsById(competitionId)) {
                competitionMasterDetailsRepository.deleteById(competitionId);
                return true;
            }
            return false;
        } catch (Exception e) {
            logger.error("Exception occurred while deleting competition ID {}: {}", competitionId, e.getMessage(), e);
            throw new DataAccessException("Data access exception occurred while deleting competition", e);
        }
    }
}
