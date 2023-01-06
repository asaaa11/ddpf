package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.VcprepMapper;
import com.example.demo.mapper.XinYeMapper;
import com.example.demo.pojo.XinYe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XinYeService {
    @Autowired
    private XinYeMapper xinYeMapper;
    @Autowired
    private VcprepMapper vcprepMapper;
    public Boolean insert(XinYe xinYe){
        return xinYeMapper.insert(xinYe)>0;
    }
    public Boolean insert1(demo.domain.Vcprep vcprep){
        return vcprepMapper.insert(vcprep)>0;
    }
    public Boolean delete(Integer id){
        return xinYeMapper.deleteById(id)>0;
    }
    public Boolean update(XinYe xinYe){
        return xinYeMapper.updateById(xinYe)>0;
    }
    public List<XinYe> select(String liaohao){
        QueryWrapper wrapper=new QueryWrapper<XinYe>();
        if(liaohao!=null&&!liaohao.equals("")) {
            wrapper.apply("liaohao='"+liaohao+"'");
        }
        return xinYeMapper.selectList(wrapper);
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
