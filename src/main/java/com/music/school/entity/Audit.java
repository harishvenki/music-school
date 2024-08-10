package com.music.school.entity;

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
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at", nullable = false, updatable = false)
    @UpdateTimestamp
    private Date updatedAt;

    @Column(name = "created_by", columnDefinition = "varchar(255) default 'APPLICATION'")
    private String createdBy;

    @Column(name = "updated_by", columnDefinition = "varchar(255) default 'APPLICATION'")
    private String updatedBy;
}
