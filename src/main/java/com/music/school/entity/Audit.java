package com.music.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Audit {

    @JsonIgnore
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @JsonIgnore
    @Column(name = "updated_at", nullable = false, updatable = false)
    @UpdateTimestamp
    private Date updatedAt;

    @JsonIgnore
    @Column(name = "created_by", columnDefinition = "varchar(255) default 'APPLICATION'")
    private String createdBy;

    @JsonIgnore
    @Column(name = "updated_by", columnDefinition = "varchar(255) default 'APPLICATION'")
    private String updatedBy;
}
