package com.userapi.app.rest.UserController;


import com.userapi.app.rest.Repo.UserRepo;
import com.userapi.app.rest.UserModel.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiControllers {
    @Autowired
    private UserRepo repo;

    @GetMapping(value = "/")
    public String getPage(){
        return "welcome";
    }
    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return repo.findAll();
    }
    @GetMapping (value = "/id={id}")
    public User getUser(@PathVariable long id, User user) {
            return repo.findById(id).get();
    }
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody @NotNull User user){
        repo.save(user);
        System.out.println(user.getName() + user.getEmail() + user.isAdmin() +user.getId());
        return "blah blah " + user.getName();
    }
    @CrossOrigin
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody @NotNull User user) {
        User updatedUser = repo.findById(id).get();
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setAdmin(user.isAdmin());
        updatedUser.setInfluencer(user.isInfluencer());
        repo.save(updatedUser);
        return "Updated" +user.getName()+updatedUser.getName();
    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id, User user) {
        repo.deleteById(id);
        return "User Banned";
    }
}
