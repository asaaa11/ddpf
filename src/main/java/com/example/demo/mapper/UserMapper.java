package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.pojo.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {
    int insert(User u);
    List<User> selectList(@Param(Constants.WRAPPER) Wrapper wrapper);
    int updateById(@Param(Constants.ENTITY) User u);
    int deleteById(Serializable id);
}
