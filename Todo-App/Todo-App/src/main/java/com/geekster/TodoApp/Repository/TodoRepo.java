package com.geekster.TodoApp.Repository;

import com.geekster.TodoApp.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepo {

    @Autowired
    public List<Todo> MyTodos;

    public List<Todo> getMytodos() {
        return MyTodos;
    }

    public void add(Todo todo) {
        MyTodos.add(todo);
    }

    public void delete(Todo todo) {
        MyTodos.remove(todo);
    }
}
