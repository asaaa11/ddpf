package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.pojo.TongkongYaoQiu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface TongKongMapper extends BaseMapper<TongkongYaoQiu> {
    int insert(TongkongYaoQiu m);
    List<TongkongYaoQiu> selectList(@Param(Constants.WRAPPER) Wrapper wrapper);
    int deleteById(Serializable id);
    int updateById(@Param(Constants.ENTITY) TongkongYaoQiu m);
}
