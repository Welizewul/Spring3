package com.example.sem3_HomeTask.utils;

import com.example.sem3_HomeTask.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserMapper - класс реализует интерфейс RowMapper<User>, который используется для отображения результатов запроса
 * к базе данных в объект типа User.
 * Аннотация @Component позволяет Spring автоматически обнаружить данный класс и создать экземпляр класса.
 */
@Component
public class UserMapper implements RowMapper<User> {
    /**
     * mapRow - метод принимает ResultSet и индекс строки и возвращает объект типа User,
     * заполняя его данными из ResultSet.
     *
     * @return - объект User.
     * @throws SQLException
     */
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}