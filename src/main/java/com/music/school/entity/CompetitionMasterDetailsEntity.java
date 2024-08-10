package com.music.school.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "competition_master_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionMasterDetailsEntity extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competition_id")
    private Integer competitionId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseMasterDetailsEntity course;

    @Column(name = "audio_files")
    private String audioFiles;

    @Column(name = "video_files")
    private String videoFiles;

    @Column(name = "description_text")
    private String descriptionText;

    @Column(name = "image")
    private String image;

    @Column(name = "status", nullable = false)
    private Character status;
}
