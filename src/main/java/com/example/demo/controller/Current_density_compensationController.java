package com.example.demo.controller;

import com.example.demo.pojo.Current_density_compensation;
import com.example.demo.service.Current_density_compensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("compensation")
public class Current_density_compensationController {
    @Autowired
    private Current_density_compensationService service;
    @GetMapping("find")
    public List<Current_density_compensation> select(@RequestParam String holes,String Ckind){
        return service.select(holes,Ckind);
    }
    @PostMapping("add")
    public Boolean add(@RequestBody Current_density_compensation c){
        return service.insert(c);
    }
    @PutMapping("update")
    public Boolean update(@RequestBody Current_density_compensation c){
        return service.update(c);
    }
    @DeleteMapping("delete")
    public Boolean delete(@RequestParam String id){
        return service.delete(id);
    }
}
