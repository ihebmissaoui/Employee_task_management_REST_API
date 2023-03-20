package com.fst.ids4.restapi.employee_task_management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fst.ids4.restapi.employee_task_management.helpers.ErrorResponse;

import com.fst.ids4.restapi.employee_task_management.models.Task;
import com.fst.ids4.restapi.employee_task_management.services.TaskService;

@RestController

@RequestMapping("/api/tasks")
public class TaskController {

  private final TaskService taskService;

  @Autowired
  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping
  public List<Task> getAlltasks() {
    return taskService.findAllTasks();
  }

  @GetMapping("/{id}")
  public Task gettaskById(@PathVariable String id) {
    return taskService.findTaskById(id);
  }

  @PostMapping
  public Task addtask(@RequestBody Task task) throws Exception {
    if (taskService.saveTask(task) != null)
      return taskService.saveTask(task);
    else

    {
      throw new Exception("An error has occurred : saving task");

    }
  }

  @PutMapping("/{id}")
  public Task updatetask(@PathVariable String id, @RequestBody Task task) {
    return taskService.updateTask(id, task);
  }

  @DeleteMapping("/{id}")
  public void deletetask(@PathVariable String id) {
    taskService.deleteTask(id);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception ex) {
    ErrorResponse response = new ErrorResponse("Error", ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
