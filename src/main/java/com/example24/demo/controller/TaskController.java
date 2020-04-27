package com.example24.demo.controller;

import com.example24.demo.entity.Task;
import com.example24.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAll(){
        return taskService.getAll();
    }
    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id){
        return taskService.getById(id);
    }
    @PostMapping
    public Task create(@RequestBody Task task){
        return taskService.create(task);
    }
    @PutMapping
    public Task update(@RequestBody Task task){
        return taskService.update(task);
    }
    @DeleteMapping
    public Task deleteById(@RequestParam(name = "id") Long id){
        return taskService.deleteById(id);
    }
    @GetMapping("/title")
    public List<Task> searchByTitle(@RequestHeader String title){
        return taskService.searchByTitle(title);
    }
    @GetMapping("/text")
    public List<Task> searchByText(@RequestHeader String text){
        return taskService.searchByText( text);
    }

}
