package com.example.demo;

import com.example.demo.pojo.ExcelSY;
import com.example.demo.service.ExcelSYService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private ExcelSYService table3Service;
    @Test
    void contextLoads() {
        List<ExcelSY> list=table3Service.selectList("HP2423351B1");
       System.out.println( list.get(0) );
    }

}
