package com.fisher.progress.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "workout")
@Data
public class Workout {
    @Id
    private String id;
    private LocalDateTime date;
    private List<Exercise> exercise;

    public Workout(String id, LocalDateTime date, List<Exercise> exercise) {
        this.id = id;
        this.date = LocalDateTime.now();;
        this.exercise = exercise;
    }
}
