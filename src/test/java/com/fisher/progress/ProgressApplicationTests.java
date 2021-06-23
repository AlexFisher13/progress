package com.fisher.progress;

import com.fisher.progress.dao.IWorkoutRepository;
import com.fisher.progress.domain.Exercise;
import com.fisher.progress.domain.Set;
import com.fisher.progress.domain.Workout;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ProgressApplicationTests {

    @Autowired
    IWorkoutRepository repo;

    private Workout createWorkout() {
        List<Set> sets = Arrays.asList(
                new Set((float) Math.random(), (int) (Math.random()*10)),
                new Set((float) Math.random(), (int) (Math.random()*10)),
                new Set((float) Math.random(), (int) (Math.random()*10)));
        List<Exercise> exercises = Arrays.asList(
                new Exercise("pullups", sets),
                new Exercise("pushups", sets),
                new Exercise("twisting", sets));
        return new Workout(null, null, exercises);
    }

    @Test
    void addWorkout() {
        Workout workout = createWorkout();
        repo.save(workout);
    }

    @Test
    void getAllWorkouts() {
        repo.findAll();
    }

}
