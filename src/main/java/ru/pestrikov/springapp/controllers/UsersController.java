package ru.pestrikov.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pestrikov.springapp.dao.UserDaoImpl;
import ru.pestrikov.springapp.model.User;

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

    @GetMapping("/users")
    public String show(@RequestParam("id") int id, Model model) { //get int from url param

        //get 1 user from dao and give to view

        model.addAttribute("users", userDao.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userDao.save(user);
        return "redirect:http://localhost:8080/";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userDao.show(id));
        return "edit";
    }


    @PatchMapping()
    public String update(@ModelAttribute("user") User user,
                         @RequestParam("id") int id) {
        userDao.update(id, user);
        return "redirect:http://localhost:8080/";
    }

    @DeleteMapping("/{id}")
    public String delete(@RequestParam int id) {
        userDao.delete(id);
        return "redirect:http://localhost:8080/";
    }
}