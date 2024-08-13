package com.music.school.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "competition_master_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @Column(name = "audio_files")
    private String audioFiles;

    @Column(name = "video_files")
    private String videoFiles;

    @Column(name = "description_text")
    private String descriptionText;

    @Column(name = "image")
    private String image;

    @Column(name = "status", nullable = false)
    private String status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseMasterDetailsEntity course;
}
