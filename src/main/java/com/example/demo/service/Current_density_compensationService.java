package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.Current_density_compensationMapper;
import com.example.demo.pojo.Current_density_compensation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class Current_density_compensationService {
    @Autowired
    private Current_density_compensationMapper mapper;

    public List<Current_density_compensation> select(String holes,String Ckind){
        QueryWrapper wrapper=new QueryWrapper<Current_density_compensation>();
        if (holes!=null&&!holes.equals("")) {
            wrapper.apply(" holes like  '%"+holes+"%' " );
        }
        if (Ckind!=null&&!Ckind.equals("")) {
            wrapper.apply(" Ckind = '"+Ckind+"' " );
        }
        return mapper.selectList(wrapper);
    }
    public Boolean insert(Current_density_compensation c){
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        c.setId(format.format(date));
        return mapper.insert(c)>0;
    }
    public Boolean update(Current_density_compensation c){
        return mapper.updateById(c)>0;
    }
    public Boolean delete(String id){
        return mapper.deleteById(id)>0;
    }
}
