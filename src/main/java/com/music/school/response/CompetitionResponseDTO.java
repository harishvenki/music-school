package com.music.school.response;

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
        private String audioFiles;
        private String videoFiles;
        private String shortDescription;
        private String descriptionText;
        private String image;
        private String status;
        private Boolean isUserEnrolled;
        private String courseList;
        private List<PrizeDetails> prize;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PrizeDetails {
        String batchId;
        String studentName;
        String prizeName;
        String teacherComments;
    }
}
