package com.music.school.controller;

import com.music.school.entity.CompetitionDetailsEntity;
import com.music.school.entity.CompetitionMasterDetailsEntity;
import com.music.school.exception.ResourceNotFoundException;
import com.music.school.request.CompetitionDetailsDTO;
import com.music.school.response.CompetitionDetailsByIdResponseDTO;
import com.music.school.response.CompetitionDetailsRequestDTO;
import com.music.school.response.CompetitionResponseDTO;
import com.music.school.response.ErrorResponseDTO;
import com.music.school.service.CompetitionService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competition")
@Slf4j
public class CompetitionController {
    private static final Logger logger = LoggerFactory.getLogger(CompetitionController.class);

    @Autowired
    CompetitionService competitionService;

    @GetMapping
    ResponseEntity<CompetitionResponseDTO> getCompetitions(@RequestParam(name = "competitionId", required = false) Integer competitionId, @RequestParam(name = "status") String status, @RequestParam(name = "userId", required = false) Integer userId, @RequestParam(name = "type", required = false) String type) {
        return ResponseEntity.ok(competitionService.getCompetition(competitionId, status, userId, type));
    }

    @PostMapping
    public ResponseEntity<CompetitionMasterDetailsEntity> createCompetition(@RequestBody CompetitionDetailsRequestDTO competition) {
        CompetitionMasterDetailsEntity createdCompetition = competitionService.createCompetition(competition);
        return new ResponseEntity<>(createdCompetition, HttpStatus.CREATED);
    }

    @PutMapping("/{competitionId}")
    public ResponseEntity<CompetitionMasterDetailsEntity> updateCompetition(
            @PathVariable Integer competitionId,
            @RequestBody CompetitionResponseDTO.Competition competition) {
        CompetitionMasterDetailsEntity updatedCompetition = competitionService.updateCompetition(competitionId, competition);
        if (updatedCompetition != null) {
            return new ResponseEntity<>(updatedCompetition, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetition(@PathVariable Integer competitionId) {
        boolean deleted = competitionService.deleteCompetition(competitionId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{competitionId}/student/{studentId}")
    public ResponseEntity<?> getCompetitionDetailsByCompetitionIdAndStudentId(@PathVariable Integer competitionId, @PathVariable Integer studentId) {
        try {
            CompetitionDetailsEntity competitionDetailsEntities = competitionService.getCompetitionDetailsByCompetitionIdAndStudentId(competitionId, studentId);
            return ResponseEntity.ok(competitionDetailsEntities);
        } catch (ResourceNotFoundException e) {
            ErrorResponseDTO errorResponse = new ErrorResponseDTO(e.getMessage(), HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } catch (Exception e) {
            ErrorResponseDTO errorResponse = new ErrorResponseDTO("Error retrieving competition details: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/details/{competitionId}")
    public ResponseEntity<?> getCompetitionDetailsByCompetitionId(@PathVariable Integer competitionId, @RequestParam(name = "teacherId", required = false) Integer teacherId, @RequestParam(name = "type", required = false) String type) {
        try {
            List<CompetitionDetailsByIdResponseDTO> competitionDetailsEntityList = competitionService.getCompetitionDetailsByCompetitionId(competitionId, teacherId, type);
            return ResponseEntity.status(HttpStatus.OK).body(competitionDetailsEntityList);
        } catch (ResourceNotFoundException e) {
            logger.error("ResourceNotFoundException occurred while storing competition details, {}", e.getMessage(), e);
            ErrorResponseDTO errorResponse = new ErrorResponseDTO(e.getMessage(), HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Exception occurred while storing competition details, {}", e.getMessage(), e);
            ErrorResponseDTO errorResponse = new ErrorResponseDTO("Error creating competition details: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorResponse);
        }
    }

    @PostMapping("/details")
    public ResponseEntity<?> createCompetitionDetails(@RequestBody CompetitionDetailsDTO competitionDetailsDTO) {
        try {
            CompetitionDetailsEntity competitionDetailsEntity = competitionService.createCompetitionDetails(competitionDetailsDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(competitionDetailsEntity);
        } catch (ResourceNotFoundException e) {
            logger.error("ResourceNotFoundException occurred while storing competition details, {}", e.getMessage(), e);
            ErrorResponseDTO errorResponse = new ErrorResponseDTO(e.getMessage(), HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Exception occurred while storing competition details, {}", e.getMessage(), e);
            ErrorResponseDTO errorResponse = new ErrorResponseDTO("Error creating competition details: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorResponse);
        }
    }

    @PutMapping("/details")
    public ResponseEntity<?> updateCompetitionDetails(@RequestBody CompetitionDetailsDTO competitionDetailsDTO) {
        try {
            CompetitionDetailsEntity competitionDetailsEntity = competitionService.updateCompetitionDetails(competitionDetailsDTO);
            return ResponseEntity.status(HttpStatus.OK).body(competitionDetailsEntity);
        } catch (ResourceNotFoundException e) {
            logger.error("ResourceNotFoundException occurred while updating competition details, {}", e.getMessage(), e);
            ErrorResponseDTO errorResponse = new ErrorResponseDTO(e.getMessage(), HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Exception occurred while updating competition details, {}", e.getMessage(), e);
            ErrorResponseDTO errorResponse = new ErrorResponseDTO("Error updating competition details: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorResponse);
        }
    }
}
