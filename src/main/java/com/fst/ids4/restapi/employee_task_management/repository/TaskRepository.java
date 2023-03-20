package com.fst.ids4.restapi.employee_task_management.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fst.ids4.restapi.employee_task_management.models.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
}