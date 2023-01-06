package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.XuQiu1Mapper;
import com.example.demo.pojo.XuQiu1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<XuQiu1> select( String biaomian){
        QueryWrapper wrapper=new QueryWrapper<XuQiu1>();
        if(biaomian!=null&&!biaomian.equals("")) {
            wrapper.apply(" biaomian like '%"+biaomian+"%' ");
        }
        return xuQu1Mapper.selectList(wrapper);
    }
}






/*@Service
public class PcDcService {
    @Autowired
    private PcDcMapper pcDcMapper;
    public Boolean insert(PcDc pcDc){
        return pcDcMapper.insert(pcDc)>0;
    }
    public Boolean delete(Integer id){
        return pcDcMapper.deleteById(id)>0;
    }
    public Boolean update(PcDc pcDc){
        return pcDcMapper.updateById(pcDc)>0;
    }
    public List<PcDc> select(String container, String itecode){
        QueryWrapper wrapper=new QueryWrapper<PcDc>();
        if(container!=null&&!container.equals(""))wrapper.apply(" container like '%"+container+"%' ");
        if(itecode!=null&&!itecode.equals(""))wrapper.apply(" itecode like '%"+itecode+"%' ");
        return pcDcMapper.selectList(wrapper);
    }
}*/
