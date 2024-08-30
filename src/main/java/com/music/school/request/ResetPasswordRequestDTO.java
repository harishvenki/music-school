package com.music.school.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordRequestDTO {
    String userName;
    String oldPassword;
    String newPassword;
}
