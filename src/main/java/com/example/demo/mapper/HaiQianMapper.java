package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.pojo.HaiQian;
import com.example.demo.pojo.XuQiu1;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.Wrapper;
import java.util.List;
@Repository
public interface HaiQianMapper extends BaseMapper<HaiQian> {
    int insert(HaiQian haiQian);
}



/*@Repository
public interface XuQiu1Mapper extends BaseMapper<XuQiu1> {
    int insert(XuQiu1 xuQiu1);
    int deleteById(Serializable id);
    int updateById(@Param(Constants.ENTITY) XuQiu1 xuQiu1);
    List<XuQiu1> selectList(@Param(Constants.WRAPPER) Wrapper wrapper);
}*/
