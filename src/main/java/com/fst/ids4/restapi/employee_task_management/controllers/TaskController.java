package com.fst.ids4.restapi.employee_task_management.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    
    @GetMapping("/welcom")
public String hello()
{
    return "First message";
}

}
