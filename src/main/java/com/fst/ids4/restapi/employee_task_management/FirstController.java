package com.fst.ids4.restapi.employee_task_management;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    
    @GetMapping("/welcom")
public String hello()
{
    return "salut";
}

}
