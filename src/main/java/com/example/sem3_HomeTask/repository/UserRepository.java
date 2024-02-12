package com.example.sem3_HomeTask.repository;

import com.example.sem3_HomeTask.domain.User;
import com.example.sem3_HomeTask.utils.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * UserRepository - класс, реализующий работу с репозиторием.
 */
@Component
public class UserRepository {
    private final JdbcTemplate jdbc;

    private final UserMapper userMapper;

    /**
     * Конструктор класса  UserRepository
     *
     * @param jdbc       - управление созданием экземпляра JdbcTemplate и его инъекцией в поле jdbc.
     * @param userMapper - отображение результатов запроса к базе данных в объекте типа User.
     */
    public UserRepository(JdbcTemplate jdbc, UserMapper userMapper) {
        this.jdbc = jdbc;
        this.userMapper = userMapper;
    }

    /**
     * Получение списка пользователей.
     *
     * @return список пользователей.
     */
    public List<User> getUsers() {
        String sql = "select * from \"user\"";
        return jdbc.query(sql, userMapper);
    }

    /**
     * Добавление пользователя в БД.
     *
     * @param user объект пользователя.
     */
    public void addUser(User user) {
        String sql = "insert into \"user\" (name, age, email) values (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }
}