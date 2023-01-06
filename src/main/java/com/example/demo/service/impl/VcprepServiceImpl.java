package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.VcprepMapper;
import com.example.demo.service.VcprepService;
import demo.domain.Vcprep;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author HBJLPC0230
* @description 针对表【vcprep】的数据库操作Service实现
* @createDate 2022-10-22 09:10:18
*/
@Service
public class VcprepServiceImpl extends ServiceImpl<VcprepMapper, Vcprep>
    implements VcprepService {
@Autowired
private VcprepMapper vcprepMapper;
    @Override
    public List<Vcprep> select(String liaohao) {
        QueryWrapper wrapper=new QueryWrapper<Vcprep>();
        wrapper.apply(" liaohao ='"+liaohao+"' ");
        return vcprepMapper.selectList(wrapper) ;
    }
}




