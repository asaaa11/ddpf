package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.pojo.Tp_value;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface Tp_valueMapper extends BaseMapper<Tp_value> {
    /*int insert(Tp_value t);
    List<Tp_value> selectList(@Param(Constants.WRAPPER) Wrapper wrapper);
    int updateById(@Param(Constants.ENTITY) Tp_value t);
    int deleteById(Serializable id);*/
}
