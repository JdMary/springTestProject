package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//a business service layer
@Service
@AllArgsConstructor
public class ServiceTask {

    @Autowired
    private TaskRepository taskRepository;

    //This annotation tells Spring to automatically inject the TaskRepository dependency into the TaskService class.
    /*Why it’s used: Instead of manually creating or initializing a TaskRepository object,
     Spring handles the creation and injection of the appropriate instance for you.*/

    /*public ServiceTask(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }*/

    public List<Task> getAllTasks() {
taskRepository.findAll().forEach(task -> {
            System.out.println(task.getDescription()+" "+task.getId());
        });
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTaskById( Task updatedTask) {
        return taskRepository.save(updatedTask);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

}
