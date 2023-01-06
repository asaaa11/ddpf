package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;
    public List<User> select(String username, String realname, String kind){
        QueryWrapper wrapper=new QueryWrapper<User>();
        if (username!=null&&!username.equals(""))wrapper.apply(" username like '%"+username+"%' " );
        if (realname!=null&&!realname.equals(""))wrapper.apply(" realname like '%"+realname+"%' " );
        if (kind!=null&&!kind.equals(""))wrapper.apply(" kind = '"+kind+"' " );
        return mapper.selectList(wrapper);
    }
    public Boolean insert(User t){
        return mapper.insert(t)>0;
    }
    public Boolean update(User t){
        return mapper.updateById(t)>0;
    }
    public Boolean delete(String id){
        return mapper.deleteById(id)>0;
    }
}
