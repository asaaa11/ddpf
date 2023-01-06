package com.example.demo.controller;

import com.example.demo.pojo.ExcelSY;
import com.example.demo.service.ExcelSYService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("Excel")
public class ExcelSYController {
    @Autowired
    private ExcelSYService service;
    @GetMapping("SY")
    public List<ExcelSY> selectList(@RequestParam String pn){
       return service.selectList(pn);
    }
}
