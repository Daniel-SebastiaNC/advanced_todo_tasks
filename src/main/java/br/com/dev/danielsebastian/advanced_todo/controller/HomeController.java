package br.com.dev.danielsebastian.advanced_todo.controller;

import br.com.dev.danielsebastian.advanced_todo.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {


    private final TaskRepository repository;

    public HomeController(TaskRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/")
    ModelAndView home(){
        var modelAndView = new ModelAndView("home");
        modelAndView.addObject("nome", "Daniel Sebastian");
        var alunos = List.of("Pricila", "Maria", "Mickey");
        modelAndView.addObject("alunos", alunos);
        modelAndView.addObject("ehProgamador", false);

        var tasks = repository.findAll();
        System.out.println(tasks);

        return modelAndView;


    }
}
