package com.sammy.simpletodowebapp.Todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {
    private static List<ToDo> toDos=new ArrayList<>();
    private static int count=0;

    static {
        toDos.add(new ToDo(++count,"in 28minutes","AWS learn",LocalDate.now().plusYears(1),false));
        toDos.add(new ToDo(++count,"in 28minutes","Linux",LocalDate.now().plusYears(2),false));
        toDos.add(new ToDo(++count,"in 28minutes","Jaeger",LocalDate.now().plusYears(3),false));

    }


    public List<ToDo> getByUserName(String name){
        return toDos;
    }
    public void addTodo(String name,String description,LocalDate target,boolean done){
        ToDo todo=new ToDo(++count,name,description,target,done);
        toDos.add(todo);
    }
    public void deleteId(int id){
        Predicate<? super ToDo> predicate=toDo -> toDo.getId()==id ;
        toDos.removeIf(predicate);
    }
    public void updateid(@Valid ToDo toDo){
        deleteId(toDo.getId());
        toDos.add(toDo);
    }

    public ToDo findById(int id) {
        Predicate<? super ToDo> predicate=toDo -> toDo.getId()==id ;
        ToDo todo=toDos.stream().filter(predicate).findFirst().get();
        return todo;
    }
}
