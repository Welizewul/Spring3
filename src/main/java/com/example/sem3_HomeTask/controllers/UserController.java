package com.example.sem3_HomeTask.controllers;

import com.example.sem3_HomeTask.domain.User;
import com.example.sem3_HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * UserController - класс, реализующий взаимодействия с Tomcat и добавления пользователей в базу данных.
 */

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired // Spring должен внедрить (inject) указанный bean в качестве зависимости для данного класса или метода.
    private RegistrationService service;   // Сервис регистрации пользователей.

    /**
     * Получение списка пользователей из репозитория.
     *
     * @return JSON ответ со списком пользователей.
     * @GetMapping - для определения HTTP GET запроса, который будет обрабатываться в контроллере.
     */
    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    /**
     * userAddFromBody - метод обработки POST-запросов, предназначенный для добавления нового пользователя.
     * Доступен при указании пути: /body.
     *
     * @param requestBody тело запроса.
     * @return подтверждение добавления пользователя.
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody Map<String, Object> requestBody) {
        String name = (String) requestBody.get("name");
        Integer age = Integer.valueOf((String) requestBody.get("age"));
        String email = (String) requestBody.get("email");
        service.processRegistration(name, age, email);
        return "Пользователь успешно добавлен в базу данных!";
    }
}