package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.pojo.XuQiu1;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface XuQiu1Mapper extends BaseMapper<XuQiu1> {
   /* int insert(XuQiu1 xuQiu1);
    int deleteById(Serializable id);
    int updateById(@Param(Constants.ENTITY) XuQiu1 xuQiu1);
    List<XuQiu1> selectList(@Param(Constants.WRAPPER) Wrapper wrapper);
    XuQiu1 selectOne(@Param("ew") Wrapper<XuQiu1> queryWrapper);*/
}












/*
@Repository
public interface PcDcMapper extends BaseMapper<PcDc> {
    int insert(PcDc pcDc);
    int deleteById(Serializable id);
    int updateById(@Param(Constants.ENTITY) PcDc pcDc);
    List<PcDc> selectList(@Param(Constants.WRAPPER) Wrapper wrapper);
}*/
