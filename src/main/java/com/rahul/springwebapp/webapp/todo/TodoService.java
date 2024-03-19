package com.rahul.springwebapp.webapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase( username) ;
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username,String description,LocalDate targetdate,boolean done){

        Todo todo = new Todo(++todoscount,username,description,targetdate,done);
        todos.add(todo);
    }

    public void deleteTodoById(int id){

        Predicate<? super Todo> predicate = todo -> todo.getId() == id ;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id ;
        Todo todo=todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteTodoById(todo.getId());
        todos.add(todo);
    }
}
