package com.example.demo.mapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.pojo.XuQiu2;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.util.List;

@Repository
public interface XuQiu2Mapper extends BaseMapper<XuQiu2> {
   /* int insert(XuQiu2 xuQiu2);
    int deleteById(Serializable id);
    int updateById(@Param(Constants.ENTITY) XuQiu2 xuQiu2);
    List<XuQiu2> selectList(@Param(Constants.WRAPPER) Wrapper wrapper);
    XuQiu2 selectOne(@Param("ew") Wrapper<XuQiu2> queryWrapper);*/
}












/*
@Repository
public interface PcDcMapper extends BaseMapper<PcDc> {
    int insert(PcDc pcDc);
    int deleteById(Serializable id);
    int updateById(@Param(Constants.ENTITY) PcDc pcDc);
    List<PcDc> selectList(@Param(Constants.WRAPPER) Wrapper wrapper);
}*/
