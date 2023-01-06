package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.pojo.MesTable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface MesTableMapper extends BaseMapper<MesTable> {
    int insert(MesTable mesTable);
    List<MesTable> selectList(@Param(Constants.WRAPPER) Wrapper wrapper);
    int deleteById(Serializable pno);
    int updateById(@Param(Constants.ENTITY) MesTable m);
}
