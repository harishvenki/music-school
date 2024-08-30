package com.music.school.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitionDetailsDTO {
    private Integer studentId;
    private Integer competitionId;
    private String studentFile;
    private String studentComments;
    private String studentGrade;
    private String teacherComments;
    private Integer evaluatorId;
    private Integer prizeId;
    private String prizeName;
    private Integer competitionDetailsId;
    private Integer teacherId;
    private Integer lastUpdatedBy;
}
