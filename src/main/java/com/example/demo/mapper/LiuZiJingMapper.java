package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.pojo.JiSuan1;
import com.example.demo.pojo.LiuZiJing;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface LiuZiJingMapper extends BaseMapper<LiuZiJing> {
   /* int insert(LiuZiJing liuZiJing);
    int deleteById(Serializable id);
    int updateById(@Param(Constants.ENTITY) LiuZiJing l);
    List<LiuZiJing> selectList(@Param(Constants.WRAPPER) Wrapper wrapper);
    LiuZiJing selectOne(@Param("ew")Wrapper<LiuZiJing> queryWrapper);*/
}
