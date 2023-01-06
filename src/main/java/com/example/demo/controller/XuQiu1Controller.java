package com.example.demo.controller;

import com.example.demo.pojo.XuQiu1;
import com.example.demo.service.XuQiu1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RestController
@RequestMapping("XuQiu1")
public class XuQiu1Controller {
    XuQiu1 xuQiu1 = new XuQiu1();
     @Autowired
    private XuQiu1Service xuQiu1Service;
    @PostMapping("add")
    private Boolean add(@RequestBody XuQiu1 xuQiu1){
        return xuQiu1Service.insert(xuQiu1);
    }


    @DeleteMapping("delete")
    private Boolean delete(@RequestParam Integer id){
        return xuQiu1Service.delete(id);
    }
    @PutMapping("update")
    private Boolean update(@RequestBody XuQiu1 xuQiu1){
        return  xuQiu1Service.update(xuQiu1);
    }
    @GetMapping("find")
    private List<XuQiu1> select(@RequestParam String biaoMian ){
        return xuQiu1Service.select(biaoMian);
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
