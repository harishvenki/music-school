package com.music.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin_master_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminMasterDetailsEntity {
    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "display_image")
    private String displayImage;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @JsonIgnore
    @Column(name= "user_id", nullable = false)
    private Integer userId;
}
