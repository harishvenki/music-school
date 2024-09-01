package com.music.school.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompetitionDetailsByIdResponseDTO {
    private String batchId;
    private Integer competitionId;
    private Integer competitionDetailsId;
    private Integer studentId;
    private String studentName;
    private String studentFile;
    private String studentComments;
    private Date studentSubmissionDate;
    private Integer evaluatorId;
    private String evaluatedBy;
    private String studentGrade;
    private String teacherComments;
    private String prizeName;
}
