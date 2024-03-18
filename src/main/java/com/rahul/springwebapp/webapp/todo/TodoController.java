package com.rahul.springwebapp.webapp.todo;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {



    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }
    private TodoService todoService;

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("rahul");
        model.addAttribute("todos",todos);

        return "todos";
    }

    @RequestMapping(value = "/add-todos",method = RequestMethod.GET)
    public String showNewTodoPage() {

        return "addtodos";
    }

    @RequestMapping(value = "/add-todos",method = RequestMethod.POST)
    public String addTodos(@RequestParam String description,ModelMap model) {

        String username = (String) model.get("name");
        todoService.addTodo(username,description, LocalDate.now().plusYears(1),false);
        return "redirect:list-todos";
    }

}
