package com.example.demo.controller;

import com.example.demo.service.impl.VcprepServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能描述
 *
 * @author: dengyilong
 * @date: 2022年10月22日 9:13
 */
@CrossOrigin
@RestController
@MapperScan("com.example.demo.*.mapper")
@RequestMapping("vcp")
public class VcprepController {

}
