package com.example.vinofind.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@SuperBuilder
@Data
@Entity
public class Review extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long wineryId;
    private String reviewer;
    private int rating;
    private String title;
    private String text;
    private String image;
    private Timestamp timestamp;

    public Review() {
    }

    public Review(Long wineryId, String reviewer, int rating, String title, String text, String[] image) {
        super();
        this.wineryId = wineryId;
        this.reviewer = reviewer;
        this.rating = rating;
        this.title = title;
        this.text = text;
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
    }
}
