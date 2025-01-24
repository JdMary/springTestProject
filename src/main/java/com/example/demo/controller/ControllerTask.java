package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.ServiceTask;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PUBLIC)

@RequestMapping("tasks")
public class ControllerTask {
    private  ServiceTask serviceTask;
    @Autowired
    public ControllerTask(ServiceTask serviceTask) {
        this.serviceTask=serviceTask;
    }
    @GetMapping("/{id}")
    public Task getTask(Long id){
        return serviceTask.getTaskById(id);
    }

    @GetMapping("/get")
    public List<Task> getAllTasks(){
        return serviceTask.getAllTasks();
    }
    @PostMapping()
    public Task createTask(@RequestBody Task task) {
        return serviceTask.createTask(task);
    }
    @PutMapping("/update")
    public Task updateTask(@RequestBody Task task) {
        return serviceTask.updateTaskById(task);
    }
    @DeleteMapping()
    public void deleteTask(@PathVariable Long id){
        serviceTask.deleteTaskById(id);
    }
}
