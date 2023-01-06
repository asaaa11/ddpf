package com.example.demo.controller;

import com.example.demo.pojo.LiuZiJing;
import com.example.demo.pojo.user.User;
import com.example.demo.service.LiuZiJingservice;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能描述
 *
 * @author: dengyilong
 * @date: 2022年09月03日 14:54
 */
@CrossOrigin
@RestController
@RequestMapping("Liu")
public class LiuZiJingController {
    @Autowired
    private LiuZiJingservice liuZiJingservice;
    @PostMapping("add")
    public Boolean add(@RequestBody LiuZiJing t){
        return liuZiJingservice.insert(t);
    }
    @DeleteMapping("delete")
    public Boolean delete(@RequestParam Integer id){
        return liuZiJingservice.delete(id);
    }
    @PutMapping("update")
    public Boolean update(@RequestBody LiuZiJing l){
        return liuZiJingservice.update(l);
    }
    @GetMapping("find")
    public List<LiuZiJing> select(@RequestParam String houdu,String beizhu){
        return liuZiJingservice.select(houdu,beizhu);
    }
}
