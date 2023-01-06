package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.Table2Mapper;
import com.example.demo.pojo.TVrsReport;
import com.example.demo.utils.DateUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class Table2Service {
    @Autowired
    private Table2Mapper table2Mapper;
    //查内层
    public List<TVrsReport> find(String partNo,String lotNo,String ds,String de){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        if (ds==null||ds.equals("")) {
            try {
                ds= DateUtil.minusOneDay(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        if (de==null||de.equals("")){
            de=simpleDateFormat.format(date);
        }
        QueryWrapper<TVrsReport> wrapper=new QueryWrapper<>();
        boolean a = partNo!=null&&!partNo.equals("");
        boolean b = lotNo!=null&&!lotNo.equals("");
        if (a&&b){
            wrapper.apply("PartNo like '%"+partNo+"%'").apply("LotNo = '"+lotNo+"'");
        }else if (a||b) {
            wrapper.func(i->{if(a){i.apply("PartNO like '%"+partNo+"%'");}else{i.apply("LotNo = '"+lotNo+"'");}});
        }
        wrapper.apply("IsOuter = 0");
        try {
            Date date1=simpleDateFormat.parse(ds);
            Date date2=simpleDateFormat.parse(de);
            ds=simpleDateFormat.format(date1.getTime()-86400000);
            de=simpleDateFormat.format(date2.getTime()-86400000);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return table2Mapper.selectList(wrapper,ds+" 07:30:00",de+" 07:30:00");
    }
    //外层
    public List<TVrsReport> findOut(String partNo,String lotNo,String ds,String de){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        if (ds==null||ds.equals("")) {
            try {
                ds= DateUtil.minusOneDay(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        if (de==null||de.equals("")){
            de=simpleDateFormat.format(date);
        }
        QueryWrapper<TVrsReport> wrapper=new QueryWrapper<>();
        boolean a = partNo!=null&&!partNo.equals("");
        boolean b = lotNo!=null&&!lotNo.equals("");
        if (a&&b){
            wrapper.apply("PartNo like '%"+partNo+"%'").apply("LotNo = '"+lotNo+"'");
        }else if (a||b) {
            wrapper.func(i->{if(a){i.apply("PartNO like '%"+partNo+"%'");}else{i.apply("LotNo = '"+lotNo+"'");}});
        }
        wrapper.apply("IsOuter = 1");
        try {
            Date date1=simpleDateFormat.parse(ds);
            Date date2=simpleDateFormat.parse(de);
            ds=simpleDateFormat.format(date1.getTime()-86400000);
            de=simpleDateFormat.format(date2.getTime()-86400000);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return table2Mapper.selectList(wrapper,ds+" 07:30:00",de+" 07:30:00");
    }

   //导入
   /* @Transactional
    public void importExcel(MultipartFile file) throws IOException {
        List<TVrsReport> list = ExcelUtil.importExcel(file, 1, 1, TVrsReport.class);
        for (TVrsReport tVrsReport : list) {
            table2Mapper.insert(tVrsReport);
        }
    }*/


}
