package com.example.demo.controller;

import com.example.demo.pojo.Tp_value;
import com.example.demo.service.Tp_valueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("Tp")
public class Tp_valueController {
    @Autowired
    private Tp_valueService service;
    @GetMapping("find")
    public List<Tp_value> select(@RequestParam String holes, String Tkind){
        return service.select(holes,Tkind);
    }
    @PostMapping("add")
    public Boolean add(@RequestBody Tp_value t){
        return service.insert(t);
    }
    @PutMapping("update")
    public Boolean update(@RequestBody Tp_value t){
        return service.update(t);
    }
    @DeleteMapping("delete")
    public Boolean delete(@RequestParam String id){
        return service.delete(id);
    }
}
