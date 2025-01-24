package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//a business service layer
@Service
public class ServiceTask {

    private final TaskRepository taskRepository;

    //This annotation tells Spring to automatically inject the TaskRepository dependency into the TaskService class.
    /*Why it’s used: Instead of manually creating or initializing a TaskRepository object,
     Spring handles the creation and injection of the appropriate instance for you.*/
    @Autowired
    public ServiceTask(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTaskById(Long id, Task updatedTask) {
        Task existingTask = getTaskById(id);
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());
        return taskRepository.save(existingTask);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

}
