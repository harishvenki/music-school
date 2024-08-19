package com.music.school.service.Implementation;

import com.music.school.constants.Constants;
import com.music.school.entity.*;
import com.music.school.exception.DataAccessException;
import com.music.school.exception.ResourceNotFoundException;
import com.music.school.repository.*;
import com.music.school.request.CompetitionDetailsDTO;
import com.music.school.response.CompetitionDetailsByIdResponseDTO;
import com.music.school.response.CompetitionDetailsRequestDTO;
import com.music.school.response.CompetitionResponseDTO;
import com.music.school.service.CompetitionService;
import com.music.school.utils.EmailSender;
import com.music.school.utils.ResponseMapper;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CompetitionServiceImpl implements CompetitionService {
    public static final Logger logger = LoggerFactory.getLogger(CompetitionService.class);

    @Autowired
    private CompetitionMasterDetailsRepository competitionMasterDetailsRepository;

    @Autowired
    private UserMasterDetailsRepository userMasterDetailsRepository;

    @Autowired
    private CompetitionDetailsRepository competitionDetailsRepository;

    @Autowired
    private StudentMasterDetailsRepository studentMasterDetailsRepository;

    @Autowired
    private PrizeMasterDetailsRepository prizeMasterDetailsRepository;

    @Autowired
    private CourseMasterDetailsRepository courseMasterDetailsRepository;

    @Override
    public CompetitionResponseDTO getCompetition(Integer competitionId, String status, Integer studentId) {
        CompetitionResponseDTO competitionResponseDTO = new CompetitionResponseDTO();
        try {
            if (Objects.nonNull(competitionId)) {
                return competitionMasterDetailsRepository.findById(competitionId)
                        .map(entity -> ResponseMapper.mapCompetitionMasterDetailsEntity(List.of(entity)))
                        .orElseThrow(() -> new DataAccessException(String.format("No data found for competition ID: %d", competitionId), null));
            } else if (StringUtils.hasLength(status)) {
                List<CompetitionMasterDetailsEntity> competitionMasterDetailsEntity;
                if (status.equalsIgnoreCase(Constants.PAST_COMPETITION)) {
                    competitionMasterDetailsEntity = competitionMasterDetailsRepository.findByStatus(Constants.PAST_COMPETITION);
                } else if (status.equalsIgnoreCase(Constants.PRESENT_COMPETITION)) {
                    competitionMasterDetailsEntity = competitionMasterDetailsRepository.findByStatus(Constants.PRESENT_COMPETITION);
                } else if (status.equalsIgnoreCase(Constants.FUTURE_COMPETITION)) {
                    competitionMasterDetailsEntity = competitionMasterDetailsRepository.findByStatus(Constants.FUTURE_COMPETITION);
                } else {
                    competitionMasterDetailsEntity = competitionMasterDetailsRepository.findByStatus(Constants.CLOSED_COMPETITION);
                }
                if (!CollectionUtils.isEmpty(competitionMasterDetailsEntity)) {
                    competitionResponseDTO = ResponseMapper.mapCompetitionMasterDetailsEntity(competitionMasterDetailsEntity);
                }
            } else {
                Iterable<CompetitionMasterDetailsEntity> competitionMasterDetailsEntity = competitionMasterDetailsRepository.findAll();
                competitionResponseDTO = ResponseMapper.mapCompetitionMasterDetailsEntity(StreamSupport.stream(competitionMasterDetailsEntity.spliterator(), false).toList());
            }

            if (Objects.nonNull(competitionResponseDTO) && Objects.nonNull(competitionResponseDTO.getCompetitions())) {
                competitionResponseDTO.getCompetitions().forEach(competition -> {
                    Optional<CompetitionDetailsEntity> competitionDetailsEntity = competitionDetailsRepository.findByCompetition_CompetitionIdAndStudent_StudentId(competition.getCompetitionId(), studentId);
                    List<CompetitionDetailsEntity> competitionDetailsEntities = competitionDetailsRepository.findByCompetition_CompetitionId(competition.getCompetitionId());
                    List<CompetitionResponseDTO.PrizeDetails> prizeDetails = competitionDetailsEntities.stream().filter(competitionDetails -> {
                        return Objects.nonNull(competitionDetails.getPrize());
                    }).map(competitionDetails -> {
                        return CompetitionResponseDTO.PrizeDetails.builder()
                                .batchId(competitionDetails.getStudent().getBatch().getName())
                                .studentName(competitionDetails.getStudent().getFirstName() + " " + competitionDetails.getStudent().getLastName())
                                .prizeName(competitionDetails.getPrize().getName())
                                .teacherComments(competitionDetails.getTeacherComments())
                                .build();
                    }).toList();
                    competition.setPrize(prizeDetails);
                    competition.setIsUserEnrolled(competitionDetailsEntity.isPresent());
                });
            } else {
                Objects.requireNonNull(competitionResponseDTO).setCompetitions(Collections.emptyList());
                return competitionResponseDTO;
            }
        } catch (Exception e) {
            logger.error("Exception occurred while fetching competition details: {}", e.getMessage(), e);
            throw new DataAccessException("Data access exception occurred while fetching competition details", e);
        }
        return competitionResponseDTO;
    }


    // TODO: testing
    @Override
    public CompetitionMasterDetailsEntity createCompetition(CompetitionDetailsRequestDTO competition) {
        try {
            Date currentDate = new Date();
            if (competition.getStartDate().after(currentDate)) {
                competition.setStatus(Constants.FUTURE_COMPETITION);
            } else {
                competition.setStatus(Constants.PRESENT_COMPETITION);
            }

            CompetitionMasterDetailsEntity competitionMasterDetailsEntity = new CompetitionMasterDetailsEntity();
            if (competition.getTitle() != null) competitionMasterDetailsEntity.setTitle(competition.getTitle());
            if (competition.getStartDate() != null)
                competitionMasterDetailsEntity.setStartDate(competition.getStartDate());
            if (competition.getEndDate() != null)
                competitionMasterDetailsEntity.setEndDate(competition.getEndDate());
            if (competition.getAudioFiles() != null)
                competitionMasterDetailsEntity.setAudioFiles(competition.getAudioFiles());
            if (competition.getVideoFiles() != null)
                competitionMasterDetailsEntity.setVideoFiles(competition.getVideoFiles());
            if (competition.getShortDescription() != null)
                competitionMasterDetailsEntity.setShortDescription(competition.getShortDescription());
            if (competition.getDescriptionText() != null)
                competitionMasterDetailsEntity.setDescriptionText(competition.getDescriptionText());
            if (competition.getImage() != null) competitionMasterDetailsEntity.setImage(competition.getImage());
            if (competition.getStatus() != null) competitionMasterDetailsEntity.setStatus(competition.getStatus());

            if (!competition.getCourseList().isEmpty()) {
                List<String> courseNames = competition.getCourseList().stream()
                        .map(courseSelectedName -> courseMasterDetailsRepository.findByName(courseSelectedName))
                        .filter(Objects::nonNull) // Filter out null results
                        .map(CourseMasterDetailsEntity::getName)
                        .toList();
                String courseNamesString = String.join(",", courseNames);
                competitionMasterDetailsEntity.setCourseName(courseNamesString);
            }

//            List<StudentMasterDetailsEntity> studentMasterDetailsList = studentMasterDetailsRepository.findAllByStatus('A');
//            List<String> emailAddresses = new ArrayList<>();
//            for (StudentMasterDetailsEntity studentDetail : studentMasterDetailsList) {
//                emailAddresses.add(studentDetail.getEmail());
//            }
//
//            EmailSender emailSender = new EmailSender();
//            String subject = "New Music Competition Created";
//            String body = "Dear Students,\n\nWe are excited to announce a new music competition. Please check your dashboard for details.";
//
//            emailSender.sendEmail(emailAddresses, subject, body);
            return competitionMasterDetailsRepository.save(competitionMasterDetailsEntity);
        } catch (Exception e) {
            logger.error("Exception occurred while creating competition: {}", e.getMessage(), e);
            throw new DataAccessException("Data access exception occurred while creating competition", e);
        }
    }

    // TODO: testing
    @Override
    public CompetitionMasterDetailsEntity updateCompetition(Integer competitionId, CompetitionResponseDTO.Competition competition) {
        try {
            if (competitionMasterDetailsRepository.existsById(competitionId)) {
                CompetitionMasterDetailsEntity competitionMasterDetailsEntity = competitionMasterDetailsRepository.findByCompetitionId(competitionId);
                if (competition.getTitle() != null) competitionMasterDetailsEntity.setTitle(competition.getTitle());
                if (competition.getStartDate() != null)
                    competitionMasterDetailsEntity.setStartDate(competition.getStartDate());
                if (competition.getEndDate() != null)
                    competitionMasterDetailsEntity.setEndDate(competition.getEndDate());
                if (competition.getAudioFiles() != null)
                    competitionMasterDetailsEntity.setAudioFiles(competition.getAudioFiles());
                if (competition.getVideoFiles() != null)
                    competitionMasterDetailsEntity.setVideoFiles(competition.getVideoFiles());
                if (competition.getShortDescription() != null)
                    competitionMasterDetailsEntity.setShortDescription(competition.getShortDescription());
                if (competition.getDescriptionText() != null)
                    competitionMasterDetailsEntity.setDescriptionText(competition.getDescriptionText());
                if (competition.getImage() != null) competitionMasterDetailsEntity.setImage(competition.getImage());
                if (competition.getStatus() != null) competitionMasterDetailsEntity.setStatus(competition.getStatus());

//                if (!competition.getCourseList().isEmpty()) {
//                    List<String> courseNames = competition.getCourseList().stream()
//                            .map(courseSelectedName -> courseMasterDetailsRepository.findByName(courseSelectedName))
//                            .filter(Objects::nonNull) // Filter out null results
//                            .map(CourseMasterDetailsEntity::getName)
//                            .toList();
//                    String courseNamesString = String.join(",", courseNames);
//                    competitionMasterDetailsEntity.setCourseName(courseNamesString);
//                }
                competitionMasterDetailsRepository.save(competitionMasterDetailsEntity);
                return competitionMasterDetailsEntity;
            }
            return null;
        } catch (Exception e) {
            logger.error("Exception occurred while updating competition ID {}: {}", competitionId, e.getMessage(), e);
            throw new DataAccessException("Data access exception occurred while updating competition", e);
        }
    }

    // TODO: testing
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

    public CompetitionDetailsEntity getCompetitionDetailsByCompetitionIdAndStudentId(Integer competitionId, Integer studentId) {
        return competitionDetailsRepository.findByCompetition_CompetitionIdAndStudent_StudentId(competitionId, studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Competition details not found for competition id " + competitionId + " and student id " + studentId));
    }

    @Override
    public List<CompetitionDetailsByIdResponseDTO> getCompetitionDetailsByCompetitionId(Integer competitionId) {
        List<CompetitionDetailsEntity> competitionDetailsEntityList = competitionDetailsRepository.findByCompetition_CompetitionId(competitionId);
        if (competitionDetailsEntityList.isEmpty())
            return Collections.emptyList();

        return competitionDetailsEntityList.stream().map(competitionDetails -> CompetitionDetailsByIdResponseDTO.builder()
                .batchId(competitionDetails.getStudent().getBatch().getName())
                .competitionId(competitionDetails.getCompetition().getCompetitionId())
                .competitionDetailsId(competitionDetails.getCompetitionDetailsId())
                .studentId(competitionDetails.getStudent().getStudentId())
                .studentName(competitionDetails.getStudent().getFirstName() + " " + competitionDetails.getStudent().getLastName())
                .studentFile(competitionDetails.getStudentFile())
                .studentComments(competitionDetails.getStudentComments())
                .studentSubmissionDate(competitionDetails.getSubmissionDate())
                .evaluatorId(competitionDetails.getEvaluatorId())
                .studentGrade(competitionDetails.getStudentGrade())
                .teacherComments(competitionDetails.getTeacherComments())
                .prizeName(competitionDetails.getPrize() != null ? competitionDetails.getPrize().getName() : "")
                .build()).toList();
    }

    @Transactional
    public CompetitionDetailsEntity createCompetitionDetails(CompetitionDetailsDTO competitionDetailsDTO) {
        StudentMasterDetailsEntity student = studentMasterDetailsRepository.findById(competitionDetailsDTO.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + competitionDetailsDTO.getStudentId()));

        CompetitionMasterDetailsEntity competition = competitionMasterDetailsRepository.findById(competitionDetailsDTO.getCompetitionId())
                .orElseThrow(() -> new ResourceNotFoundException("Competition not found with id " + competitionDetailsDTO.getCompetitionId()));

        PrizeMasterDetailsEntity prize = null;
        if (Objects.nonNull(competitionDetailsDTO.getPrizeId())) {
            prize = prizeMasterDetailsRepository.findByPrizeId(competitionDetailsDTO.getPrizeId());
        }

        Optional<CompetitionDetailsEntity> competitionDetailsEntityOptional = competitionDetailsRepository.findByCompetition_CompetitionIdAndStudent_StudentId(competition.getCompetitionId(), competitionDetailsDTO.getStudentId());

        if (competitionDetailsEntityOptional.isPresent()) {
            throw new DataAccessException("Competition already registered for the given student");
        }

        CompetitionDetailsEntity competitionDetailsEntity = CompetitionDetailsEntity.builder()
                .student(student)
                .competition(competition)
                .studentFile(competitionDetailsDTO.getStudentFile())
                .studentComments(competitionDetailsDTO.getStudentComments())
                .submissionDate(new Date())
                .studentGrade(competitionDetailsDTO.getStudentGrade())
                .teacherComments(competitionDetailsDTO.getTeacherComments())
                .evaluatorId(competitionDetailsDTO.getEvaluatorId())
                .prize(prize)
                .build();

        return competitionDetailsRepository.save(competitionDetailsEntity);
    }


    @Transactional
    public CompetitionDetailsEntity updateCompetitionDetails(CompetitionDetailsDTO competitionDetailsDTO) {
        CompetitionDetailsEntity competitionDetailsEntity = competitionDetailsRepository.findByCompetitionDetailsId(competitionDetailsDTO.getCompetitionDetailsId());
        if (Objects.nonNull(competitionDetailsEntity)) {
            if (Objects.nonNull(competitionDetailsDTO.getTeacherId()))
                competitionDetailsEntity.setEvaluatorId(competitionDetailsDTO.getTeacherId());
            if (Objects.nonNull(competitionDetailsDTO.getTeacherComments()))
                competitionDetailsEntity.setTeacherComments(competitionDetailsDTO.getTeacherComments());
            if (Objects.nonNull(competitionDetailsDTO.getStudentGrade()))
                competitionDetailsEntity.setStudentGrade(competitionDetailsDTO.getStudentGrade());
            if (Objects.nonNull(competitionDetailsDTO.getPrizeName())) {
                PrizeMasterDetailsEntity prizeMasterDetailsEntity = prizeMasterDetailsRepository.findByName(competitionDetailsDTO.getPrizeName());
                if (Objects.isNull(prizeMasterDetailsEntity)) {
                    throw new DataAccessException("Enter valid prize details!");
                }
                competitionDetailsEntity.setPrize(prizeMasterDetailsEntity);
            }
            return competitionDetailsRepository.save(competitionDetailsEntity);
        } else {
            throw new DataAccessException("Competition details not found for update!");
        }
    }
}
