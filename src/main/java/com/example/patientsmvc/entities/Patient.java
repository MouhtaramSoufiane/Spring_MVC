package com.example.patientsmvc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private Boolean malade;
    @Temporal(TemporalType.DATE)
    private Date date_naissance;
    private int score;
}
