package com.music.school.service.Implementation;

import com.music.school.entity.BatchMasterDetailsEntity;
import com.music.school.entity.CourseMasterDetailsEntity;
import com.music.school.exception.DataAccessException;
import com.music.school.repository.BatchMasterDetailsRepository;
import com.music.school.repository.CourseMasterDetailsRepository;
import com.music.school.response.CourseBatchDetailsResponseDTO;
import com.music.school.service.CompetitionService;
import com.music.school.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    public static final Logger logger = LoggerFactory.getLogger(CompetitionService.class);

    @Autowired
    CourseMasterDetailsRepository courseMasterDetailsRepository;

    @Autowired
    BatchMasterDetailsRepository batchMasterDetailsRepository;

    @Override
    public CourseBatchDetailsResponseDTO getAllCoursesAndBatchDetails(){
        try {
            List<CourseMasterDetailsEntity> courseMasterDetailsEntity = courseMasterDetailsRepository.findAllByOrderByNameAsc();
            List<BatchMasterDetailsEntity> batchMasterDetailsEntity = batchMasterDetailsRepository.findAllByOrderByNameAsc();
            return CourseBatchDetailsResponseDTO.builder().batchMasterDetails(batchMasterDetailsEntity)
                    .courseMasterDetails(courseMasterDetailsEntity).build();
        } catch (Exception e){
            logger.error("Exception occurred while fetching competition details: {}", e.getMessage(), e);
            throw new DataAccessException("Data access exception occurred while fetching competition details", e);
        }
    }
}
