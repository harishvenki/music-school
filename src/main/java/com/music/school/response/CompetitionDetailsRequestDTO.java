package com.music.school.response;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompetitionDetailsRequestDTO {
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
    private List<String> courseList;
    private String tags;
    private String thumbnail;
}
