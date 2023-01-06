package com.example.demo.controller;

import com.example.demo.pojo.MesTable;
import com.example.demo.pojo.Messge;
import com.example.demo.service.MesTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("Mes")
public class MesTableController {
    @Autowired
    private MesTableService service;
    @PostMapping("add")
    public Boolean add(@RequestBody MesTable mesTable){
        return service.insert(mesTable);
    }
    @GetMapping("find")
    public List<MesTable> select(@RequestParam String job_name,String lot_no,String pno){
        return service.select(job_name,lot_no,pno);
    }
    @DeleteMapping("delete")
    public int delete(@RequestParam String pno){
        return service.delete(pno);
    }
    @PutMapping("update")
    public int update(@RequestBody MesTable m){
        return service.update(m);
    }
    @GetMapping("findbyPno")
    public Messge select(@RequestParam String pno){
        return service.selectByPno(pno);
    }
}
