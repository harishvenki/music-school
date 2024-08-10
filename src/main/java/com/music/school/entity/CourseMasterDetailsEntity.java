package com.music.school.entity;

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

    @OneToMany(mappedBy = "course")
    private List<BatchMasterDetailsEntity> batches;

    @OneToMany(mappedBy = "course")
    private List<StudentMasterDetailsEntity> students;

    @OneToMany(mappedBy = "course")
    private List<TeacherMasterDetailsEntity> teachers;

    @OneToMany(mappedBy = "course")
    private List<CompetitionMasterDetailsEntity> competitions;
}
