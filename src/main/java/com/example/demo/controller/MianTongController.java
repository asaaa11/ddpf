package com.example.demo.controller;

import com.example.demo.pojo.MianTongXiaoLv;
import com.example.demo.service.MianTongXiaoLvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("MianTong")
public class MianTongController {
    @Autowired
    private MianTongXiaoLvService service;

    @GetMapping("find")
    public List<MianTongXiaoLv> select(@RequestParam String holes, String Mkind){
        return service.select(holes,Mkind);
    }
    @PostMapping("add")
    public Boolean add(@RequestBody MianTongXiaoLv c){
        return service.insert(c);
    }
    @PutMapping("update")
    public Boolean update(@RequestBody MianTongXiaoLv c){
        return service.update(c);
    }
    @DeleteMapping("delete")
    public Boolean delete(@RequestParam String id){
        return service.delete(id);
    }
}
