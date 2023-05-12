package com.sammy.simpletodowebapp.Todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
public class ToDo {

    public ToDo() {

    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", target=" + target +
                ", done=" + done +
                '}';
    }

    @Id
    @GeneratedValue
    private int id;

    private String userName;
    @Size(min = 10,message = "Enter atleast 10 characters")
    private String description;

    private LocalDate target;
    private boolean done;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTarget() {
        return target;
    }

    public void setTarget(LocalDate target) {
        this.target = target;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public ToDo(int id, String userName, String description, LocalDate target, boolean done) {
        super();
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.target = target;
        this.done = done;
    }


}
