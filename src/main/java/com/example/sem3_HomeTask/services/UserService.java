package com.example.sem3_HomeTask.services;

import com.example.sem3_HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService - класс создания пользователей.
 */
@Service
public class UserService {
    @Autowired
    private NotificationService notificationService;

    /**
     * Создание нового пользователя.
     * @param name имя пользователя.
     * @param age возраст пользователя.
     * @param email email пользователя.
     * @return созданного пользователя.
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        notificationService.notifyUser(user);      // Отправляем уведомление о создании нового пользователя.

        return user;
    }
}