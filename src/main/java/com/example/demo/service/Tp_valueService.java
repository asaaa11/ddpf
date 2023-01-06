package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.Tp_valueMapper;
import com.example.demo.pojo.Tp_value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class Tp_valueService {
    @Autowired
    private Tp_valueMapper mapper;

    public List<Tp_value> select(String holes, String Tkind){
        QueryWrapper wrapper=new QueryWrapper<Tp_value>();
        if (holes!=null&&!holes.equals(""))wrapper.apply(" holes like  '%"+holes+"%' " );
        if (Tkind!=null&&!Tkind.equals(""))wrapper.apply(" Tkind = '"+Tkind+"' " );
        return mapper.selectList(wrapper);
    }
    public Boolean insert(Tp_value t){
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        t.setId(format.format(date));
        return mapper.insert(t)>0;
    }
    public Boolean update(Tp_value t){
        return mapper.updateById(t)>0;
    }
    public Boolean delete(String id){
        return mapper.deleteById(id)>0;
    }
}
