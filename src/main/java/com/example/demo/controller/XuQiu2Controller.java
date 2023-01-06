package com.example.demo.controller;

import com.example.demo.pojo.XuQiu2;
import com.example.demo.service.XuQiu2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}


/*
@CrossOrigin
@RestController
@RequestMapping("PcDc")
public class PcDcController {
    @Autowired
    private PcDcService pcDcService;
    @PostMapping("add")
    private Boolean add(@RequestBody PcDc pcDc){
        return pcDcService.insert(pcDc);
    }
    @DeleteMapping("delete")
    private Boolean delete(@RequestParam Integer id){
        return pcDcService.delete(id);
    }
    @PutMapping("update")
    private Boolean update(@RequestBody PcDc pcDc){
        return  pcDcService.update(pcDc);
    }
    @GetMapping("find")
    private List<PcDc> select(@RequestParam String container, String itecode){
        return pcDcService.select(container,itecode);
    }
}*/
