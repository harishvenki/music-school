package com.music.school.service;

import com.music.school.request.LoginRequestDTO;
import com.music.school.response.LoginResponseDTO;

public interface UserService {
    LoginResponseDTO login(LoginRequestDTO loginRequest);
}
