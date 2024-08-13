package com.music.school.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "batch_master_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchMasterDetailsEntity extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id")
    private Integer batchId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseMasterDetailsEntity course;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherMasterDetailsEntity teacher;

    @JsonIgnore
    @OneToMany(mappedBy = "batch")
    private List<StudentMasterDetailsEntity> students;
}
