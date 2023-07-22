package com.geekster.TodoApp.controller;

import com.geekster.TodoApp.model.Todo;
import com.geekster.TodoApp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    public TodoController(){

    }

    @PostMapping("todo")
    public String addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @GetMapping("todos")
    public List<Todo> getAlltodos(){
        return todoService.getAlltodos();
    }

    @GetMapping("todos/{todoId}")
    public Todo getTodoById(@PathVariable Integer todoId){
        return todoService.getTodoById(todoId);
    }

    @PutMapping("todo/{todoId}/{status}")
    public String markTodo(@PathVariable Integer todoId, @PathVariable boolean status){
        return todoService.updateTodosStatus(todoId, status);
    }

    @DeleteMapping("todo/{todoId}")
    public String removeTodo(@PathVariable Integer todoId){
        return todoService.removeTodo(todoId);
    }


}
