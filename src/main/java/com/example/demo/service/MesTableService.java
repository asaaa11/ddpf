package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.LogMapper;
import com.example.demo.mapper.MesTableMapper;
import com.example.demo.pojo.Log;
import com.example.demo.pojo.MesTable;
import com.example.demo.pojo.Messge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class MesTableService {
    @Autowired
    private MesTableMapper mapper;
    @Autowired
    private LogMapper logMapper;

    private Date date=new Date();
    public Boolean insert(MesTable mesTable){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        mesTable.setDate(java.sql.Date.valueOf(format.format(date)));
        return mapper.insert(mesTable) > 0;
    }
    public List<MesTable> select(String job_name,String lot_no,String pno){
        QueryWrapper wrapper=new QueryWrapper<MesTable>();
        if (job_name!=null&&!job_name.equals(""))wrapper.apply(" job_name like '%"+job_name+"%' ");
        if (lot_no!=null&&!lot_no.equals(""))wrapper.apply(" lot_no like '%"+lot_no+"%' ");
        if (pno!=null&&!pno.equals(""))wrapper.apply(" pno = '"+pno+"' ");
       return mapper.selectList(wrapper);
    }
    public int delete(String pno){
        return mapper.deleteById(pno);
    }
    public int update(MesTable m){
        return mapper.updateById(m);
    }
    public Messge selectByPno(String pno){
        QueryWrapper wrapper=new QueryWrapper<MesTable>();
        if (pno!=null&&!pno.equals(""))wrapper.apply(" pno = '"+pno+"' ");
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
        List<MesTable> list=mapper.selectList(wrapper);
        Messge messge;
        if (list.isEmpty()){
            messge=new Messge(format.format(date),"NotFound","",null);
        }else {
            MesTable m=list.get(0);
            messge=new Messge(format.format(date),"ok","",m);
        }
        logMapper.insert(new Log(pno,format.format(date)));
        return messge;
    }
}
