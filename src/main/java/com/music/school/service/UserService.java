package com.music.school.service;

import com.music.school.request.CreateUserRequestDTO;
import com.music.school.request.LoginRequestDTO;
import com.music.school.request.ResetPasswordRequestDTO;
import com.music.school.response.CreateUserResponseDTO;
import com.music.school.response.GetStudentResponseDTO;
import com.music.school.response.LoginResponseDTO;

import java.util.List;

public interface UserService {
    LoginResponseDTO login(LoginRequestDTO loginRequest);

    List<GetStudentResponseDTO> getAllStudents();

    GetStudentResponseDTO getUserProfile(String userId, String type);

    CreateUserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO);

    CreateUserResponseDTO reset(ResetPasswordRequestDTO resetPasswordRequestDTO);
}
