package ru.pestrikov.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pestrikov.springapp.dao.UserDaoImpl;

@Controller
@RequestMapping
public class UsersController {

    private UserDaoImpl userDao;

    @Autowired
    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        //get all users from dao
        //and give all user to view

        model.addAttribute("users", userDao.index());
        return "index";
    }

    @GetMapping("/user")
    public String show(@RequestParam(value = "id") int id, Model model) { //get int from url param

        //get 1 user from dao and give to view

        model.addAttribute("users", userDao.show(id));
        return "show";
    }
}
