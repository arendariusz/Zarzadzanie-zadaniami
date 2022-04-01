package com.example.taskmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository movieRepository) {
        this.taskRepository = movieRepository;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) Status status) {
        List<Task> taskList;
        Task task = new Task();

        if (status != null) {
            taskList = taskRepository.findByStatus(status);
        } else {
            taskList = taskRepository.findAll();
        }

        model.addAttribute("taskList", taskList);
        model.addAttribute("task", task);
        model.addAttribute("dateNow", LocalDate.now());
        return "home";
    }

    @PostMapping("/add")
    public String addTask(Task task) {
        taskRepository.save(task);
        return "home";
    }

//    @PostMapping("/setAsRealized")
//    public String setTaskAsRealized(Task task) {
//        task.setStatus(Status.REALIZED);
//        return "home";
//    }

}
