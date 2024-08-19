package com.music.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "course_master_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseMasterDetailsEntity extends Audit {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<BatchMasterDetailsEntity> batches;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<StudentMasterDetailsEntity> students;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<TeacherMasterDetailsEntity> teachers;
}
