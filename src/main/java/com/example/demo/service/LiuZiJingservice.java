package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.LiuZiJingMapper;
import com.example.demo.pojo.LiuZiJing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 功能描述
 *
 * @author: dengyilong
 * @date: 2022年09月03日 14:45
 */
@Service
public class LiuZiJingservice {
    @Autowired
    private LiuZiJingMapper liuZiJingMapper;
    public Boolean insert(LiuZiJing t){
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        t.setRiqi(format.format(date));
        return liuZiJingMapper.insert(t)>0;
    }
    public Boolean delete(Integer id){
        return liuZiJingMapper.deleteById(id)>0;
    }
    public Boolean update(LiuZiJing l){
        return liuZiJingMapper.updateById(l)>0;
    }
    public List<LiuZiJing> select(String houdu, String beizhu){
        QueryWrapper wrapper=new QueryWrapper<LiuZiJing>();
        if(houdu!=null&&!houdu.equals(""))wrapper.apply(" houdu ="+houdu+" ");
        if(beizhu!=null&&!beizhu.equals(""))wrapper.apply(" beizhu like '%"+beizhu+"%' ");
        return liuZiJingMapper.selectList(wrapper);
    }
}
