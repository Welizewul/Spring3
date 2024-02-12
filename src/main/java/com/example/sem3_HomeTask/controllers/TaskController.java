package com.example.sem3_HomeTask.controllers;

import com.example.sem3_HomeTask.domain.User;
import com.example.sem3_HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * TaskController - класс, реализующий методы работы с информацией в безе данных.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService service;  // Сервис обработки задач.

    /**
     * Получение списка поддерживаемых задач.
     * @return список задач.
     */
    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    /**
     * Получение списка пользователей отсортированных по возрасту.
     * @return JSON ответ со списком пользователей.
     */
    @GetMapping("/sort")
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Получение списка пользователей старше заданного возраста.
     * @param age возраст пользователей.
     * @return JSON ответ со списком пользователей.
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age){
        List<User> users = service.getRepository().getUsers();
        return service.filterUsersByAge(users, age);
    }

    /**
     * Получение среднего возраста пользователей.
     * @return JSON ответ со средним возрастом.
     */
    @GetMapping("/calc")
    public double calculateAverageAge(){
        List<User> users = service.getRepository().getUsers();
        return service.calculateAverageAge(users);
    }
}