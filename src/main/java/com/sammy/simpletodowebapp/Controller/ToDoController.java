package com.sammy.simpletodowebapp.Controller;

import com.sammy.simpletodowebapp.Todo.ToDo;
import com.sammy.simpletodowebapp.Todo.ToDoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoController {

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    private ToDoService toDoService;


    @RequestMapping(value = "/list-todos")
    public String listAlltodos(ModelMap modelMap){
        List<ToDo> toDos =toDoService.getByUserName("in 28minutes");
        modelMap.addAttribute("toDos",toDos);
        return "listTodos";
    }
    @RequestMapping(value = "/addtodo",method = RequestMethod.GET)
    public String showNewToDo(ModelMap modelMap){
        String username=(String) modelMap.get("name");
        ToDo todo=new ToDo(0,username,"default",LocalDate.now().plusYears(2),false);
        modelMap.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "/addtodo",method = RequestMethod.POST)
    public String addNewToDo(ModelMap modelMap, @ModelAttribute("todo") @Valid ToDo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        String username=(String) modelMap.get("name");
        toDoService.addTodo(username,todo.getDescription(), todo.getTarget(),false);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam int id){
        toDoService.deleteId(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "update-todo",method = RequestMethod.GET)
    public String updateTodo(@RequestParam int id,ModelMap modelMap){
        ToDo toDo=toDoService.findById(id);
        modelMap.addAttribute("todo",toDo);
        return "todo";
    }
    @RequestMapping(value = "update-todo",method = RequestMethod.POST)
    public String updateTodo(ModelMap modelMap,@Valid @ModelAttribute("todo") ToDo toDo,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "todo";
        }
        String username=(String)modelMap.get("name");
        toDoService.updateid(toDo);
        return "redirect:list-todos";
    }
}
