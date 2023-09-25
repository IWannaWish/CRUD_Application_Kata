package ru.pestrikov.springapp.dao;

import org.springframework.stereotype.Component;
import ru.pestrikov.springapp.model.User;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao{

    @Override
    public List<User> index() {
        return null;
    }

    @Override
    public User show(int id) {
        return null;
    }
}
