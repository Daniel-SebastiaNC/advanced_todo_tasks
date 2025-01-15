package br.com.dev.danielsebastian.advanced_todo.controller;

import br.com.dev.danielsebastian.advanced_todo.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class TaskController {


    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/")
    ModelAndView list(){
    //var modelAndView = new ModelAndView("task/list");
    //modelAndView.addObject("tasks", repository.findAll());
    //return modelAndView;
        return new ModelAndView(
                "tasks/list",
                Map.of("tasks", repository.findAll())
        );
    }
}
