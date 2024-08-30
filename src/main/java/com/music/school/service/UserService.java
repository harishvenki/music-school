package com.music.school.service;

import com.music.school.request.CreateUserRequestDTO;
import com.music.school.request.LoginRequestDTO;
import com.music.school.request.ResetPasswordRequestDTO;
import com.music.school.response.CreateUserResponseDTO;
import com.music.school.response.LoginResponseDTO;

public interface UserService {
    LoginResponseDTO login(LoginRequestDTO loginRequest);
    CreateUserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO);
    CreateUserResponseDTO reset(ResetPasswordRequestDTO resetPasswordRequestDTO);
}
