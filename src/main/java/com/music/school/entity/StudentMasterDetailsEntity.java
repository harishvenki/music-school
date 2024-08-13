package com.music.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_master_details")
public class StudentMasterDetailsEntity extends Audit {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "display_image")
    private String displayImage;

    @Column(name = "status", nullable = false)
    private Character status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseMasterDetailsEntity course;

    @JsonIgnore
    @Column(name= "user_id", nullable = false)
    private Integer userId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private BatchMasterDetailsEntity batch;
}
