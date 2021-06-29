package com.fisher.progress.controller;

import com.fisher.progress.dao.IWorkoutRepository;
import com.fisher.progress.domain.Exercise;
import com.fisher.progress.domain.Set;
import com.fisher.progress.domain.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    IWorkoutRepository repo;

    @CrossOrigin
    @GetMapping("/all")
    public List<Workout> findAll() {
        return repo.findAll();
    }

    @CrossOrigin
    @GetMapping("{id}")
    public Workout getWorkoutById(@PathVariable String id) throws Exception {
        return repo.findById(id).orElseThrow(() -> new Exception("Workout not found"));
    }

    @CrossOrigin
    @PostMapping("/addworkout")
    public void addWorkout(@RequestBody Workout workout) {
        repo.save(workout);
    }

    @CrossOrigin
    @DeleteMapping("{id}")
    public void deleteWorkout(@PathVariable String id) {
        repo.deleteById(id);
    }

    @CrossOrigin
    @PutMapping("/{id}/addexercise")
    public void addExercise(
            @PathVariable String id,
            @RequestBody Exercise exercise) throws Exception {
        Workout workout = repo.findById(id).orElseThrow(() -> new Exception("Workout not found"));
        workout.getExercise().add(exercise);
        repo.save(workout);
    }

    @CrossOrigin
    @PutMapping("/{id}/addset")
    public void addset(
            @PathVariable String id,
            @RequestParam String exerciseName,
            @RequestBody Set set) throws Exception {
        Workout workout = repo.findById(id).orElseThrow(() -> new Exception("Workout not found"));
        Exercise exercise = workout.getExercise().stream().
                filter(e -> e.getName().equals(exerciseName)).findFirst()
                .orElseThrow(() -> new Exception("Exercise not found"));
        exercise.getSets().add(set);
        repo.save(workout);
    }
}
