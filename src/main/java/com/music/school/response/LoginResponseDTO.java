package com.music.school.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDTO {
    private String message;
    private String token;
    private String role;
    private String userName;
    private Integer studentId;
    private Integer teacherId;
}
