package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.ServiceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class ControllerTask {
    private final ServiceTask serviceTask;
    @Autowired
    public ControllerTask(ServiceTask serviceTask) {
        this.serviceTask=serviceTask;
    }
    @GetMapping("/{id}")
    public Task getTask(Long id){
        return serviceTask.getTaskById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return serviceTask.createTask(task);
    }
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,@RequestBody Task task) {
        return serviceTask.updateTaskById(id,task);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        serviceTask.deleteTaskById(id);
    }
}
