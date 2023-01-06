package com.example.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.example.demo.pojo.TVrsReport;
import com.example.demo.utils.DemoDataListener;
import com.example.demo.utils.ExcelAnalysisHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelController {
    @PostMapping("/read")
    public void get(@RequestPart("file") MultipartFile file) {

        ExcelAnalysisHelper<TVrsReport> excelAnalysisHelper = new ExcelAnalysisHelper<>();
        List<TVrsReport> list = excelAnalysisHelper.getList(file,TVrsReport.class, 0, 3);
        System.out.println(list);
        DemoDataListener demoDataListener = new DemoDataListener(5);
        EasyExcel.read(file.getName(), TVrsReport.class, demoDataListener).headRowNumber(4).sheet().doRead();
        List data = demoDataListener.getData();
        System.out.println(data);
//        for (int i = 0; i < data.size(); i++) {
//            data.get(i).setString(list.get(i).getString());
//        }
//        System.out.println(data);
    }


}
