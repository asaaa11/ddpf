package com.example.demo.controller;

import com.example.demo.pojo.user.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("find")
    public List<User> select(@RequestParam String username, String realname, String kind){
        return service.select(username,realname,kind);
    }
    @PostMapping("add")
    public Boolean add(@RequestBody User t){
        return service.insert(t);
    }
    @PutMapping("update")
    public Boolean update(@RequestBody User t){
        return service.update(t);
    }
    @DeleteMapping("delete")
    public Boolean delete(@RequestParam String id){
        return service.delete(id);
    }
}
