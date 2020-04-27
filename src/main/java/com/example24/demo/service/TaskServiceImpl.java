package com.example24.demo.service;

import com.example24.demo.entity.Task;
import com.example24.demo.entity.Task;
import com.example24.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task deleteById(Long id) {
        Task task = deleteById(id);
        if (task != null){
            taskRepository.deleteById(id);
        }
        return task;
    }

    @Override
    public List<Task> searchByTitle(String title) {
        return taskRepository.findAllByTitleContainingIgnoringCase(title);
    }

    @Override
    public List<Task> searchByText(String text) {
        return taskRepository.findAllByTextContainingIgnoringCase(text);
    }
}
