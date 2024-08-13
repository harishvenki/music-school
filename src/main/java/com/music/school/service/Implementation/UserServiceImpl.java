package com.music.school.service.Implementation;

import com.music.school.constants.Constants;
import com.music.school.controller.UserController;
import com.music.school.entity.StudentMasterDetailsEntity;
import com.music.school.entity.TeacherMasterDetailsEntity;
import com.music.school.entity.UserMasterDetailsEntity;
import com.music.school.repository.StudentMasterDetailsRepository;
import com.music.school.repository.TeacherMasterDetailsRepository;
import com.music.school.repository.UserMasterDetailsRepository;
import com.music.school.request.LoginRequestDTO;
import com.music.school.response.LoginResponseDTO;
import com.music.school.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    public static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserMasterDetailsRepository userMasterDetailsRepository;

    @Autowired
    TeacherMasterDetailsRepository teacherMasterDetailsRepository;

    @Autowired
    StudentMasterDetailsRepository studentMasterDetailsRepository;


    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequest){
        try {
            UserMasterDetailsEntity userMasterDetailsEntity = userMasterDetailsRepository.findByUserName(loginRequest.getUserName());
            if (Objects.nonNull(userMasterDetailsEntity) && userMasterDetailsEntity.getPassword().equals(loginRequest.getPassword())) {
                if(userMasterDetailsEntity.getType().equalsIgnoreCase(Constants.STUDENT)){
                    StudentMasterDetailsEntity studentMasterDetailsEntity = studentMasterDetailsRepository.findByUserId(userMasterDetailsEntity.getUserId());
                    return LoginResponseDTO.builder().role(userMasterDetailsEntity.getType())
                            .message("Login successful").token("dummy-token")
                            .studentId(studentMasterDetailsEntity.getStudentId()).build();
                } else if(userMasterDetailsEntity.getType().equalsIgnoreCase(Constants.TEACHER)) {
                    TeacherMasterDetailsEntity teacherMasterDetailsEntity = teacherMasterDetailsRepository.findByUserId(userMasterDetailsEntity.getUserId());
                    return LoginResponseDTO.builder().role(userMasterDetailsEntity.getType())
                            .message("Login successful").token("dummy-token")
                            .teacherId(teacherMasterDetailsEntity.getTeacherId()).build();
                }
            }
        } catch (Exception e){
            logger.error("Exception occurred while logging in user {}", e.getMessage());
        }
        return new LoginResponseDTO("Invalid username or password",null, null,null, null);
    }
}
