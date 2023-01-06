package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.MianTongXiaoLvMapper;
import com.example.demo.pojo.Current_density_compensation;
import com.example.demo.pojo.MianTongXiaoLv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MianTongXiaoLvService {
    @Autowired
    private MianTongXiaoLvMapper mapper;

    public List<MianTongXiaoLv> select( String holes,String Mkind){
        QueryWrapper wrapper=new QueryWrapper<Current_density_compensation>();
        if (holes!=null&&!holes.equals(""))wrapper.apply(" holes like  '%"+holes+"%' " );
        if (Mkind!=null&&!Mkind.equals(""))wrapper.apply(" Mkind = '"+Mkind+"' " );
        return mapper.selectList(wrapper);
    }
    public Boolean insert(MianTongXiaoLv c){
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        c.setId(format.format(date));
        return mapper.insert(c)>0;
    }
    public Boolean update(MianTongXiaoLv c){
        return mapper.updateById(c)>0;
    }
    public Boolean delete(String id){
        return mapper.deleteById(id)>0;
    }
}
