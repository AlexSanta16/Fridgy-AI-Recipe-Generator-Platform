package com.project.Fridgy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @Column(nullable = false)
    private int rating;


    @Column(length = 200)
    private String comment;

    public Review() {}

    public Review(Recipe recipe, User user, int rating, String comment) {
        this.recipe = recipe;
        this.user = user;
        this.rating = rating;
        this.comment = comment;
    }
}
