package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.pojo.Current_density_compensation;
import com.example.demo.pojo.JiSuan1;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.util.List;

@Repository
public interface Current_density_compensationMapper extends BaseMapper<Current_density_compensation> {
   /* int insert(Current_density_compensation c);
    List<Current_density_compensation> selectList(@Param(Constants.WRAPPER) Wrapper wrapper);
    int updateById(@Param(Constants.ENTITY) Current_density_compensation c);
    int deleteById(Serializable id);
    Current_density_compensation selectOne(@Param("ew")Wrapper<Current_density_compensation> queryWrapper);*/
}
