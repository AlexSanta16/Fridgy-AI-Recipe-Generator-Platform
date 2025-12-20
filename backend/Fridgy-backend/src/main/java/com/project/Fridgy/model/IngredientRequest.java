package com.project.Fridgy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class IngredientRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String symbol;

    @ManyToOne
    private User requestedBy;

    private String status;
    private String adminMessage;
}
