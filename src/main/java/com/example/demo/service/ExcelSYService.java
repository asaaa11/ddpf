package com.example.demo.service;

import com.example.demo.mapper.ExcelSYMapper;
import com.example.demo.pojo.ExcelSY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExcelSYService {
    @Autowired
    private ExcelSYMapper excelSYMapper;
    //@pn：型号
    public List<ExcelSY> selectList(String pn){
        return excelSYMapper.SelectByProNo(pn);
    }
}
