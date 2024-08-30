package com.music.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;

@Entity
@Table(name = "competition_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompetitionDetailsEntity extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competition_details_id")
    private Integer competitionDetailsId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competition_id", nullable = false)
    private CompetitionMasterDetailsEntity competition;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentMasterDetailsEntity student;

    @Column(name = "student_file", nullable = false)
    private String studentFile;

    @Column(name = "student_comments")
    private String studentComments;

    @Column(name = "submission_date", nullable = false)
    private Date submissionDate;

    @Column(name = "student_grade")
    private String studentGrade;

    @Column(name = "teacher_comments")
    private String teacherComments;

    @Column(name = "evaluator_id")
    private Integer evaluatorId;

    @Column(name = "last_updated_by")
    private Integer lastUpdatedBy;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prize_id")
    private PrizeMasterDetailsEntity prize;
}