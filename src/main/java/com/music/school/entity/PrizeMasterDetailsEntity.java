package com.music.school.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prize_master_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrizeMasterDetailsEntity extends Audit {
    @Id
    @Column(name = "prize_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prizeId;

    @Column(name = "name", nullable = false)
    private String name;
}
