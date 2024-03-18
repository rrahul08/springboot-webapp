package com.rahul.springwebapp.webapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List <Todo> todos = new ArrayList<>();

    private static int todoscount = 0;

    static {
        todos.add(new Todo(++todoscount,"rahul","Learn Springboot", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todoscount,"rahul","Learn Java", LocalDate.now().plusYears(2),true));
        todos.add(new Todo(++todoscount,"rahul","Learn React", LocalDate.now().plusYears(3),false));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }

    public void addTodo(String username,String description,LocalDate targetdate,boolean done){

        Todo todo = new Todo(++todoscount,username,description,targetdate,done);
        todos.add(todo);
    }

}
