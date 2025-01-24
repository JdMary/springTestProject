package com.example.demo.service;

import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//a business service layer
@Service
public class ServiceTask {
    //This annotation tells Spring to automatically inject the TaskRepository dependency into the TaskService class.
    /*Why it’s used: Instead of manually creating or initializing a TaskRepository object,
     Spring handles the creation and injection of the appropriate instance for you.*/
    @Autowired
    private TaskRepository taskRepository;
}
