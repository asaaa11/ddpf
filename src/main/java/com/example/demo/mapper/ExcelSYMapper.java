package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.ExcelSY;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcelSYMapper extends BaseMapper {
    @Select("exceltable '${p}'")
    List<ExcelSY> SelectByProNo(@Param("p") String ProNo);
}
