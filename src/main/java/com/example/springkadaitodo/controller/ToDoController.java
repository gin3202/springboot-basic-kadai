package com.example.springkadaitodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.service.ToDoService;

@Controller
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/todo")
    public String showTodoList(Model model) {
        model.addAttribute("todoList", toDoService.getAllTodos());
        return "todoView";
    }
}

