package com.music.school.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_master_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseMasterDetailsEntity course;

    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private BatchMasterDetailsEntity batch;
}
