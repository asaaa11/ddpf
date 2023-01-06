package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.XuQiu2Mapper;
import com.example.demo.pojo.XuQiu1;
import com.example.demo.pojo.XuQiu2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XuQiu2Service {
    @Autowired
    private XuQiu2Mapper xuQu2Mapper ;
    public Boolean insert(XuQiu2 xuQiu2){
        return xuQu2Mapper.insert(xuQiu2)>0;
    }
    public Boolean delete(Integer id){
        return xuQu2Mapper.deleteById(id)>0;
    }
    public Boolean update(XuQiu2 xuQiu2){
        return xuQu2Mapper.updateById(xuQiu2)>0;
    }
    public List<XuQiu2> select( String biaomian){
        QueryWrapper wrapper=new QueryWrapper<XuQiu2>();

        if(biaomian!=null&&!biaomian.equals("")) {
            wrapper.apply(" biaomian like '%"+biaomian+"%' ");
        }
        return xuQu2Mapper.selectList(wrapper);
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
