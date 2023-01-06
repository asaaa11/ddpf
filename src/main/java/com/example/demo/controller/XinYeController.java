package com.example.demo.controller;

import com.example.demo.pojo.XinYe;
import com.example.demo.service.XinYeService;
import demo.domain.Vcprep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@CrossOrigin
@RequestMapping("XinYe")
public class XinYeController {
    @Autowired
    private XinYeService xinYeService;
    @PostMapping("add")
    private Map<String,Object> add(@RequestBody XinYe xinYe ){
        demo.domain.Vcprep vcprep=new Vcprep();
        vcprep.setLiaohao(xinYe.getLiaohao());
        Map<String,Object> map=new HashMap<>();
        map.put("XinYe",xinYeService.insert(xinYe));
        map.put("Vcprep",xinYeService.insert1(vcprep));
        return map;
    }
    @DeleteMapping("delete")
    private Boolean delete(@RequestParam Integer id){
        return xinYeService.delete(id);
    }
    @PutMapping("update")
    private Boolean update(@RequestBody XinYe xinYe){
        return  xinYeService.update(xinYe);
    }
    @GetMapping("find")
    private List<XinYe> select(@RequestParam String liaohao ){
        return xinYeService.select(liaohao);
    }
}
   /* @GetMapping("find")
    private List<XuQiu1> select(@RequestParam String biaoMian ){
        return xuQiu1Service.select(biaoMian);
    }*/




/*
@Controller
@RestController
@CrossOrigin
@RequestMapping("XuQiu2")
public class XuQiu2Controller {
    @Autowired
    private XuQiu2Service xuQiu2Service;
    @PostMapping("add")
    private Boolean add(@RequestBody XuQiu2 xuQiu2){
        return xuQiu2Service.insert(xuQiu2);
    }
    @DeleteMapping("delete")
    private Boolean delete(@RequestParam Integer id){
        return xuQiu2Service.delete(id);
    }
    @PutMapping("update")
    private Boolean update(@RequestBody XuQiu2 xuQiu2){
        return  xuQiu2Service.update(xuQiu2);
    }
    @GetMapping("find")
    private List<XuQiu2> select(@RequestParam String biaomian ){
        return xuQiu2Service.select(biaomian);
    }
}*/
