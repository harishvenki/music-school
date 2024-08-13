package com.music.school.response;

import com.music.school.entity.CourseMasterDetailsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitionResponseDTO {

    List<Competition> competitions;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Competition {
        private Integer competitionId;
        private String title;
        private Date startDate;
        private Date endDate;
        private CourseMasterDetailsEntity course;
        private String audioFiles;
        private String videoFiles;
        private String descriptionText;
        private String image;
        private String status;
        private Boolean isUserEnrolled;
    }
}
