package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.TongKongMapper;
import com.example.demo.pojo.TongkongYaoQiu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TongKongService {
    @Autowired
    private TongKongMapper mapper;

    public List<TongkongYaoQiu> select(String biaomianchuli){
        QueryWrapper wrapper=new QueryWrapper<TongkongYaoQiu>();
        if (biaomianchuli!=null&&!biaomianchuli.equals("")) {
            wrapper.apply(" biaomianchuli = '"+biaomianchuli+"' " );
        }
        return mapper.selectList(wrapper);
    }
    public Boolean insert(TongkongYaoQiu c){
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        c.setRiqi(format.format(date));
        return mapper.insert(c)>0;
    }
    public Boolean update(TongkongYaoQiu c){
        return mapper.updateById(c)>0;
    }
    public Boolean delete(String id){
        return mapper.deleteById(id)>0;
    }
}
