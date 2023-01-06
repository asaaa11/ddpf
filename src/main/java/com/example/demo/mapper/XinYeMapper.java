package com.example.demo.mapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.pojo.HaiQian;
import com.example.demo.pojo.XinYe;
import com.example.demo.pojo.XuQiu1;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface XinYeMapper extends BaseMapper<XinYe> {
 /*   int insert(XinYe xinYe);
    int deleteById(Serializable id);
    int updateById(@Param(Constants.ENTITY) XinYe xinYe);
    List<XinYe> selectList(@Param(Constants.WRAPPER) Wrapper wrapper);
   XinYe selectOne(@Param("ew") Wrapper<XinYe> queryWrapper);*/
/* @Select({ "call ReportPlatform._PCcompensation('${liucheng}')"
 })
 XinYe selectOne(@Param("ew") Wrapper<XinYe> queryWrapper);*/
}



/*@Repository
public interface XuQiu1Mapper extends BaseMapper<XuQiu1> {
    int insert(XuQiu1 xuQiu1);
    int deleteById(Serializable id);
    int updateById(@Param(Constants.ENTITY) XuQiu1 xuQiu1);
    List<XuQiu1> selectList(@Param(Constants.WRAPPER) Wrapper wrapper);
}*/
