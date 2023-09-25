package ru.pestrikov.springapp.dao;

import ru.pestrikov.springapp.model.User;

import java.util.List;

interface UserDao {
    List<User> index();
    User show(int id);
}
