package ru.pestrikov.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.pestrikov.springapp.model.User;
import ru.pestrikov.springapp.service.UserService;

@Controller
@RequestMapping
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService){
        this.userService=userService;
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "index";
    }

    @GetMapping("/users")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("users", userService.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:http://localhost:8080/";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }


    @PatchMapping()
    public String update(@ModelAttribute("user") User user,
                         @RequestParam("id") int id) {
        userService.update(id, user);
        return "redirect:http://localhost:8080/";
    }


    @DeleteMapping("/")
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:http://localhost:8080/";
    }

}