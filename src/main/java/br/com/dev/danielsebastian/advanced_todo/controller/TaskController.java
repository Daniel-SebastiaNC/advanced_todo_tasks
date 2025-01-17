package br.com.dev.danielsebastian.advanced_todo.controller;

import br.com.dev.danielsebastian.advanced_todo.model.Task;
import br.com.dev.danielsebastian.advanced_todo.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/create")
    ModelAndView create(){
        return new ModelAndView(
                "tasks/form",
                Map.of("task", new Task())
        );
    }

    @PostMapping("/create")
    String create(Task task){
        repository.save(task);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    ModelAndView edit(@PathVariable("id") Long id){
        var task = repository.findById(id);
        if (task.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("tasks/form", Map.of("task", task.get()));
    }

    @PostMapping("/edit/{id}")
    String edit(Task task){
        repository.save(task);
        return "redirect:/";
    }
}
