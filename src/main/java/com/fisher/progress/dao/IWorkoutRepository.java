package com.fisher.progress.dao;

import com.fisher.progress.domain.Workout;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWorkoutRepository extends MongoRepository<Workout, String> {
}
