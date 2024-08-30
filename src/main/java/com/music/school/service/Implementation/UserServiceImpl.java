package com.music.school.service.Implementation;

import com.music.school.constants.Constants;
import com.music.school.entity.*;
import com.music.school.repository.*;
import com.music.school.request.CreateUserRequestDTO;
import com.music.school.request.LoginRequestDTO;
import com.music.school.request.ResetPasswordRequestDTO;
import com.music.school.response.CreateUserResponseDTO;
import com.music.school.response.LoginResponseDTO;
import com.music.school.service.UserService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    public static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserMasterDetailsRepository userMasterDetailsRepository;

    @Autowired
    TeacherMasterDetailsRepository teacherMasterDetailsRepository;

    @Autowired
    StudentMasterDetailsRepository studentMasterDetailsRepository;

    @Autowired
    AdminMasterDetailsRepository adminMasterDetailsRepository;

    @Autowired
    BatchMasterDetailsRepository batchMasterDetailsRepository;

    @Autowired
    CourseMasterDetailsRepository courseMasterDetailsRepository;


    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        try {
            UserMasterDetailsEntity userMasterDetailsEntity = userMasterDetailsRepository.findByUserName(loginRequest.getUserName());
            if (Objects.nonNull(userMasterDetailsEntity) && userMasterDetailsEntity.getPassword().equals(loginRequest.getPassword())) {
                if (userMasterDetailsEntity.getType().equalsIgnoreCase(Constants.STUDENT)) {
                    StudentMasterDetailsEntity studentMasterDetailsEntity = studentMasterDetailsRepository.findByUserId(userMasterDetailsEntity.getUserId());
                    return LoginResponseDTO.builder().role(userMasterDetailsEntity.getType())
                            .userName(studentMasterDetailsEntity.getFirstName() + " " + studentMasterDetailsEntity.getLastName())
                            .message("Login successful").token("dummy-token")
                            .studentId(studentMasterDetailsEntity.getStudentId()).build();
                } else if (userMasterDetailsEntity.getType().equalsIgnoreCase(Constants.TEACHER)) {
                    TeacherMasterDetailsEntity teacherMasterDetailsEntity = teacherMasterDetailsRepository.findByUserId(userMasterDetailsEntity.getUserId());
                    return LoginResponseDTO.builder().role(userMasterDetailsEntity.getType())
                            .userName(teacherMasterDetailsEntity.getFirstName() + " " + teacherMasterDetailsEntity.getLastName())
                            .message("Login successful").token("dummy-token")
                            .teacherId(teacherMasterDetailsEntity.getTeacherId()).build();
                } else if (userMasterDetailsEntity.getType().equalsIgnoreCase(Constants.ADMIN)) {
                    return LoginResponseDTO.builder().role(userMasterDetailsEntity.getType())
                            .userName(userMasterDetailsEntity.getUserName())
                            .message("Login successful").token("dummy-token")
                            .build();
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while logging in user {}", e.getMessage());
        }
        return new LoginResponseDTO("Invalid username or password", null, null, null, null, null);
    }

    @Override
    @Transactional
    public CreateUserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO){
        CreateUserResponseDTO createUserResponseDTO = new CreateUserResponseDTO();
        try {
            UserMasterDetailsEntity userMasterDetailsEntityOld =  userMasterDetailsRepository.findByUserName(createUserRequestDTO.getUserName());

            if(Objects.nonNull(userMasterDetailsEntityOld)){
                createUserResponseDTO.setUserId(null);
                createUserResponseDTO.setMessage("User already exists!");
                return createUserResponseDTO;
            }

            UserMasterDetailsEntity userMasterDetailsEntity = new UserMasterDetailsEntity();
            userMasterDetailsEntity.setUserName(createUserRequestDTO.getUserName());
            userMasterDetailsEntity.setType(createUserRequestDTO.getType());
            userMasterDetailsEntity.setPassword(createUserRequestDTO.getPassword());
            userMasterDetailsEntity = userMasterDetailsRepository.save(userMasterDetailsEntity);
            createUserResponseDTO.setUserId(userMasterDetailsEntity.getUserId());
            if (userMasterDetailsEntity.getType().equalsIgnoreCase(Constants.STUDENT)) {
                StudentMasterDetailsEntity studentMasterDetailsEntity = new StudentMasterDetailsEntity();
                studentMasterDetailsEntity.setFirstName(createUserRequestDTO.getFirstName());
                studentMasterDetailsEntity.setLastName(createUserRequestDTO.getLastName());
                studentMasterDetailsEntity.setPhoneNumber(createUserRequestDTO.getPhoneNumber());
                studentMasterDetailsEntity.setEmail(createUserRequestDTO.getEmail());
                studentMasterDetailsEntity.setDisplayImage(createUserRequestDTO.getDisplayImage());
                studentMasterDetailsEntity.setStatus(createUserRequestDTO.getStatus());
                studentMasterDetailsEntity.setUserId(userMasterDetailsEntity.getUserId());
                Optional<BatchMasterDetailsEntity> batchMasterDetailsEntity = batchMasterDetailsRepository.findById(createUserRequestDTO.getBatchId());
                studentMasterDetailsEntity.setBatch(batchMasterDetailsEntity.get());
                Optional<CourseMasterDetailsEntity> courseMasterDetailsEntity = courseMasterDetailsRepository.findById(createUserRequestDTO.getCourseId());
                studentMasterDetailsEntity.setCourse(courseMasterDetailsEntity.get());
                studentMasterDetailsEntity = studentMasterDetailsRepository.save(studentMasterDetailsEntity);
                createUserResponseDTO.setStudentId(studentMasterDetailsEntity.getStudentId());
            } else if (userMasterDetailsEntity.getType().equalsIgnoreCase(Constants.TEACHER)) {
                TeacherMasterDetailsEntity teacherMasterDetailsEntity = new TeacherMasterDetailsEntity();
                teacherMasterDetailsEntity.setFirstName(createUserRequestDTO.getFirstName());
                teacherMasterDetailsEntity.setLastName(createUserRequestDTO.getLastName());
                teacherMasterDetailsEntity.setPhoneNumber(createUserRequestDTO.getPhoneNumber());
                teacherMasterDetailsEntity.setEmail(createUserRequestDTO.getEmail());
                teacherMasterDetailsEntity.setDisplayImage(createUserRequestDTO.getDisplayImage());
                teacherMasterDetailsEntity.setStatus(true);
                Optional<BatchMasterDetailsEntity> batchMasterDetailsEntity = batchMasterDetailsRepository.findById(createUserRequestDTO.getBatchId());
                teacherMasterDetailsEntity.setBatches(Collections.singletonList(batchMasterDetailsEntity.get()));
                Optional<CourseMasterDetailsEntity> courseMasterDetailsEntity = courseMasterDetailsRepository.findById(createUserRequestDTO.getCourseId());
                teacherMasterDetailsEntity.setCourse(courseMasterDetailsEntity.get());
                teacherMasterDetailsEntity.setUserId(userMasterDetailsEntity.getUserId());
                teacherMasterDetailsEntity.setCity(createUserRequestDTO.getCity());
                teacherMasterDetailsEntity = teacherMasterDetailsRepository.save(teacherMasterDetailsEntity);
                createUserResponseDTO.setTeacherId(teacherMasterDetailsEntity.getTeacherId());
            } else if (userMasterDetailsEntity.getType().equalsIgnoreCase(Constants.ADMIN)) {
                AdminMasterDetailsEntity adminMasterDetailsEntity = new AdminMasterDetailsEntity();
                adminMasterDetailsEntity.setFirstName(createUserRequestDTO.getFirstName());
                adminMasterDetailsEntity.setLastName(createUserRequestDTO.getLastName());
                adminMasterDetailsEntity.setPhoneNumber(createUserRequestDTO.getPhoneNumber());
                adminMasterDetailsEntity.setEmail(createUserRequestDTO.getEmail());
                adminMasterDetailsEntity.setDisplayImage(createUserRequestDTO.getDisplayImage());
                adminMasterDetailsEntity.setStatus(true);
                adminMasterDetailsEntity.setCity(createUserRequestDTO.getCity());
                adminMasterDetailsEntity.setUserId(userMasterDetailsEntity.getUserId());
                adminMasterDetailsEntity = adminMasterDetailsRepository.save(adminMasterDetailsEntity);
                createUserResponseDTO.setAdminId(adminMasterDetailsEntity.getAdminId());
            }
            createUserResponseDTO.setMessage("User created!");
            return createUserResponseDTO;
        } catch (Exception e){
            createUserResponseDTO.setUserId(null);
            createUserResponseDTO.setMessage("User creation failed!");
            logger.error("Exception occurred while creating user {}", e.getMessage());
        }
        return createUserResponseDTO;
    }

    @Override
    public CreateUserResponseDTO reset(ResetPasswordRequestDTO resetPasswordRequestDTO){
        CreateUserResponseDTO createUserResponseDTO = new CreateUserResponseDTO();
        try {
            UserMasterDetailsEntity userMasterDetailsEntity = userMasterDetailsRepository.findByUserName(resetPasswordRequestDTO.getUserName());
            if(Objects.nonNull(userMasterDetailsEntity)){
                if(userMasterDetailsEntity.getPassword().equals(resetPasswordRequestDTO.getOldPassword())){
                    createUserResponseDTO.setUserId(userMasterDetailsEntity.getUserId());
                    userMasterDetailsEntity.setPassword(resetPasswordRequestDTO.getNewPassword());
                    userMasterDetailsRepository.save(userMasterDetailsEntity);
                    createUserResponseDTO.setMessage("Password updated successfully!");
                } else {
                    createUserResponseDTO.setMessage("Incorrect username/password!");
                }
            } else {
                createUserResponseDTO.setMessage("Incorrect username/password!");
            }
        } catch (Exception e){
            createUserResponseDTO.setUserId(null);
            createUserResponseDTO.setMessage("Failed to update password!");
            logger.error("Exception occurred while creating user {}", e.getMessage());
        }
        return createUserResponseDTO;
    }
}
