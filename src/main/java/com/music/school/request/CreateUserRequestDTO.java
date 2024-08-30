package com.music.school.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserRequestDTO {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
    private String displayImage;
    private Character status;
    private String type;
    private Integer batchId;
    private Integer courseId;
    private String city;
}
