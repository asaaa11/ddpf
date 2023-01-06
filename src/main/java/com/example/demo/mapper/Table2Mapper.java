package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.TVrsReport;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Repository
public interface Table2Mapper extends BaseMapper<TVrsReport> {

    @Select("Exec sp_GetvrsReportDataByDate '${ds}','${de}'\n"+
            "SELECT * FROM T_VrsReport_sum ${ew.customSqlSegment} order by 'startDate' ASC \n" +
            "truncate table T_VrsReport_sum")
    List<TVrsReport> selectList(@Param("ew")QueryWrapper wrapper, @Param("ds")String ds, @Param("de")String de);


    public int excelImport(MultipartFile file) throws IOException;
}
