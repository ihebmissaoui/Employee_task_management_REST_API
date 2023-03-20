package com.fst.ids4.restapi.employee_task_management.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Document(collection ="task")
public class Task {

    @Id
    private String id;
    private String description ;
    private String idEmployee;
    public Task( String description, String idEmployee) {
        this.description = description;
        this.idEmployee = idEmployee;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
  
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getIdEmployee() {
        return idEmployee;
    }
    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }
 

} 