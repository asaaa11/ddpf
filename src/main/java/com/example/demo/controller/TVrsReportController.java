package com.example.demo.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson2.JSON;
import com.example.demo.pojo.CoalSupplyPlan;
import com.example.demo.pojo.TVrsReport;
import com.example.demo.service.Table2Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.transform.Result;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("TV")
public class TVrsReportController {
    @Autowired
    private Table2Service table2Service;
    @GetMapping("find")
    public List<TVrsReport> find(String partNo,String lotNo,String ds,String de){
        return table2Service.find(partNo,lotNo,ds,de);
    }
    @GetMapping("findOut")
    public List<TVrsReport> findout(String partNo,String lotNo,String ds,String de){
        return table2Service.findOut(partNo,lotNo,ds,de);
    }

  /*  @RequestMapping(value = "/import", method = RequestMethod.POST)
    public String importExcel(@RequestParam("file") MultipartFile file) throws Exception {
        //创建导入参数对象
        ImportParams importParams = new ImportParams();
        //前面三个表格标题占2行，从第四行占3行
        importParams.setTitleRows(2);
        //表格表头所占行数
        importParams.setHeadRows(1);
        //导入Excel表格
        List<TVrsReport> list = ExcelImportUtil.importExcel(file.getInputStream(), TVrsReport.class, importParams);
        list.forEach(System.out::println);
        return "success";
    }*/
    // 导入

    @PostMapping("/import")
    public String importExcel(@RequestParam("files") MultipartFile[] files) throws Exception {
// 创建导入参数对象
        ImportParams importParams = new ImportParams();
        // 前面三个表格标题占2行，从第四行占3行
        importParams.setTitleRows(2);
        // 表格表头所占行数
        importParams.setHeadRows(1);
        // 导入Excel表格
        List<TVrsReport> list = ExcelImportUtil.importExcel(files[0].getInputStream(), TVrsReport.class, importParams);
        list.forEach(System.out::println);
        return "success";



    }


}
