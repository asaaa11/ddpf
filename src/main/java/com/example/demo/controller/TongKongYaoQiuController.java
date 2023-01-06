package com.example.demo.controller;

import com.example.demo.pojo.TongkongYaoQiu;
import com.example.demo.service.TongKongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("TongKong")
public class TongKongYaoQiuController {
    @Autowired
    private TongKongService service;

    @GetMapping("find")
    public List<TongkongYaoQiu> select(@RequestParam String biaomianchuli){
        return service.select(biaomianchuli);
    }
    @PostMapping("add")
    public Boolean add(@RequestBody TongkongYaoQiu c){
        return service.insert(c);
    }
    @PutMapping("update")
    public Boolean update(@RequestBody TongkongYaoQiu c){
        return service.update(c);
    }
    @DeleteMapping("delete")
    public Boolean delete(@RequestParam String id){
        return service.delete(id);
    }
}
