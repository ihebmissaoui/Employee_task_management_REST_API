package com.fst.ids4.restapi.employee_task_management.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fst.ids4.restapi.employee_task_management.models.Employee;
import com.fst.ids4.restapi.employee_task_management.models.Task;
import com.fst.ids4.restapi.employee_task_management.repository.EmployeeRepository;
import com.fst.ids4.restapi.employee_task_management.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task findTaskById(String id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task saveTask(Task task) {
        // to ignore the null in the master Id (reference to master of the employee)
        if(task.getIdEmployee()==null)
        return null;
        
        Employee creatorEmployee = employeeRepository.findById(task.getIdEmployee()).orElse(null);
        if (creatorEmployee == null)
            return null;

        return taskRepository.save(task);
    }

    public Task updateTask(String id, Task task) {
        Task newTask = taskRepository.findById(id).orElse(null);
        if (newTask == null) {
            return null;
        }
        task.setId(newTask.getId());
        // ... other properties
        return taskRepository.save(task);

    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

}
