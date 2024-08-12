package com.music.school.controller;

import com.music.school.entity.CompetitionMasterDetailsEntity;
import com.music.school.response.CompetitionResponseDTO;
import com.music.school.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/competition/")
public class CompetitionController {

    @Autowired
    CompetitionService competitionService;

    @GetMapping("get")
    ResponseEntity<CompetitionResponseDTO> getCompetitions(@RequestParam(name = "competitionId", required = false) Integer competitionId){
        return ResponseEntity.ok(competitionService.getCompetition(competitionId));
    }

    @PostMapping
    public ResponseEntity<CompetitionMasterDetailsEntity> createCompetition(@RequestBody CompetitionMasterDetailsEntity competition) {
        CompetitionMasterDetailsEntity createdCompetition = competitionService.createCompetition(competition);
        return new ResponseEntity<>(createdCompetition, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompetitionMasterDetailsEntity> updateCompetition(
            @PathVariable Integer competitionId,
            @RequestBody CompetitionMasterDetailsEntity competitionDetails) {
        CompetitionMasterDetailsEntity updatedCompetition = competitionService.updateCompetition(competitionId, competitionDetails);
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
}
