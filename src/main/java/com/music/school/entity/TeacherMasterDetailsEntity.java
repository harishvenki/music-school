package com.music.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "teacher_master_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherMasterDetailsEntity extends Audit {
    @Id
    @Column(name = "teacher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;

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
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseMasterDetailsEntity course;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<BatchMasterDetailsEntity> batches;

    @JsonIgnore
    @Column(name= "user_id", nullable = false)
    private Integer userId;
}
