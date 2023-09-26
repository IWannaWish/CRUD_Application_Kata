package ru.pestrikov.springapp.dao;

import org.springframework.stereotype.Component;
import ru.pestrikov.springapp.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao{
    ArrayList<User> list = new ArrayList<>();
    @Override
    public List<User> index() {
        list.add(new User(1, "Andrei", "mail@gmail"));
        return list;
    }

    @Override
    public User show(int id) {
        return new User(1, "Andrei", "gmail");
    }

    @Override
    public void save(User user) {
        user.setId(2);
        list.add(user);
    }

    @Override
    public void delete(int id) {
        list.get(1).setName("DELETE");
    }

    @Override
    public void update(int id, User user) {
        user.setName("Update!");
    }
}
