package com.example.demo.service;

import com.example.demo.mapper.HaiQianMapper;
import com.example.demo.pojo.HaiQian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HaiQianservice {
    @Autowired
    private HaiQianMapper haiQianMapper;
    public Boolean insert(HaiQian haiQian){
        return haiQianMapper.insert(haiQian)>0;
    }
}



/*
@Service
public class XuQiu1Service {
    @Autowired
    private XuQiu1Mapper xuQu1Mapper ;
    public Boolean insert(XuQiu1 xuQiu1){
        return xuQu1Mapper.insert(xuQiu1)>0;
    }
    public Boolean delete(Integer id){
        return xuQu1Mapper.deleteById(id)>0;
    }
    public Boolean update(XuQiu1 xuQiu1){
        return xuQu1Mapper.updateById(xuQiu1)>0;
    }
    public List<XuQiu1> select(String biaomian){
        QueryWrapper wrapper=new QueryWrapper<XuQiu1>();

        if(biaomian!=null&&!biaomian.equals(""))wrapper.apply(" biaomian like '%"+biaomian+"%' ");
        return xuQu1Mapper.selectList(wrapper);
    }
}*/
