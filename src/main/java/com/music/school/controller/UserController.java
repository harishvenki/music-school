package com.music.school.controller;

import com.music.school.request.CreateUserRequestDTO;
import com.music.school.request.LoginRequestDTO;
import com.music.school.request.ResetPasswordRequestDTO;
import com.music.school.response.CreateUserResponseDTO;
import com.music.school.response.LoginResponseDTO;
import com.music.school.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
        logger.info("POST: /api/v1/users request received {}", loginRequest);
        LoginResponseDTO loginResponse = userService.login(loginRequest);
        logger.info("POST: /api/v1/users response {}", loginResponse);
        if (Objects.nonNull(loginResponse.getToken())) {
            return ResponseEntity.ok(loginResponse);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
    }

    @PostMapping("/create")
    ResponseEntity<CreateUserResponseDTO> create(@RequestBody CreateUserRequestDTO loginRequest) {
        logger.info("POST: /api/v1/create request received {}", loginRequest);
        CreateUserResponseDTO createUserResponseDTO = userService.createUser(loginRequest);
        logger.info("POST: /api/v1/create response {}", createUserResponseDTO);
        if (Objects.nonNull(createUserResponseDTO.getUserId())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponseDTO);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createUserResponseDTO);
    }

    @PostMapping("/reset/password")
    ResponseEntity<CreateUserResponseDTO> reset(@RequestBody ResetPasswordRequestDTO resetPasswordRequestDTO) {
        logger.info("POST: /api/v1/reset/password request received {}", resetPasswordRequestDTO);
        CreateUserResponseDTO resetPasswordResponse = userService.reset(resetPasswordRequestDTO);
        logger.info("POST: /api/v1/create response {}", resetPasswordResponse);
        if (Objects.nonNull(resetPasswordResponse.getUserId())) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resetPasswordResponse);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resetPasswordResponse);
    }
}
