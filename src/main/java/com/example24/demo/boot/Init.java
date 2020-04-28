package com.example24.demo.boot;

import com.example24.demo.entity.Check;
import com.example24.demo.entity.Task;
import com.example24.demo.service.CheckService;
import com.example24.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {
    @Autowired
    private TaskService taskService;
    @Autowired
    private CheckService checkService;
    @Override
    public void run(String... args) throws Exception {
        taskService.create(new Task("First Task","Create App", true));
        taskService.create(new Task("Second Task","Add Entity", true));
        taskService.create(new Task("Importent Task","Call Bos", false));
        taskService.create(new Task("Test Task","Create App", true));
        taskService.create(new Task("First Task","qwerty", false));

        checkService.create(new Check("Hello User","User"));
        checkService.create(new Check("Hello Moderator","MODERATOR"));
        checkService.create(new Check("Hello Admin","ADMIN"));



    }
}
