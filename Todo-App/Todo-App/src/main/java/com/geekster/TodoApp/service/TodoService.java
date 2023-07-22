package com.geekster.TodoApp.service;

import com.geekster.TodoApp.Repository.TodoRepo;
import com.geekster.TodoApp.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepo todoRepo;


    public String addTodo(Todo todo) {
        todoRepo.add(todo);
        return "todo added successfully!..";
    }

    public List<Todo> getAlltodos() {
        return todoRepo.getMytodos();
    }

    public Todo getTodoById(Integer todoId) {
        for(Todo todo: todoRepo.getMytodos()){
            if(todo.getTodoId().equals(todoId)){
                return todo;
            }
        }
        throw new IllegalStateException("id not found");
    }

    public String updateTodosStatus(Integer todoId, boolean status) {
        for(Todo todo: todoRepo.getMytodos()){
            if(todo.getTodoId().equals(todoId)){
                todo.setTodoDoneStatus(status);
                return "todo updated for todo ID:" + todoId;
            }
        }
        return "todo not found todo ID: " + todoId;
    }

    public String removeTodo(Integer todoId) {
        for(Todo todo: todoRepo.getMytodos()){
            if(todo.getTodoId().equals(todoId)){
                todoRepo.delete(todo);
                return "todo removed for todo ID:" + todoId;
            }
        }
        return "todo :" + todoId + " not deleted as it doesn't exist" ;
    }
}
