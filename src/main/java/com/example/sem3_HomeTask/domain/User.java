package com.example.sem3_HomeTask.domain;

/**
 * User - класс, определяющий характеристики пользователя.
 */
public class User {
    private int id;         // Уникальный идентификатор пользователя.
    private String name;    // Имя пользователя.
    private int age;        // Возраст пользователя.
    private String email;   // Адрес электронной почты.

    public User() {
    }

    // Гетеры и сеттеры.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}