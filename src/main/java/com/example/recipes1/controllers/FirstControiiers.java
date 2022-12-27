package com.example.recipes1.controllers;
import org.springframework.web.bind.annotation.*;

@RestController

public class FirstControiiers {

    @GetMapping
    public String theApplicationIsRunning() {
        return "Приложение запущено";
    }

    @GetMapping("/info")
    public String info(){
        return "Имя ученика - Лилия\n " +
                "Название проекта - книга рецептов\n " +
                "Дата создания проекта - 11 декабрь 2022 год\n " +
                "Описание проекта - сайт с рецептами";
    }

}
