package com.music.school.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.music.school.entity.BatchMasterDetailsEntity;
import com.music.school.entity.CourseMasterDetailsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseBatchDetailsResponseDTO {
    List<CourseMasterDetailsEntity> courseMasterDetails;
    List<BatchMasterDetailsEntity> batchMasterDetails;
}
