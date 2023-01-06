package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.pojo.JiSuan1;
import com.example.demo.pojo.TVrsReport;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
@Repository
public interface JiSuan1Mapper extends  BaseMapper<JiSuan1>{


  /*  @@Select("Exec _PCcompensation '#{liaohao}'\n"+
            "SELECT * XinYe ${ew.customSqlSegment} order by 'startDate' ASC \n")
*/

    /*@Select("Exec sp_GetvrsReportDataByDate '${ds}','${de}'\n"+
            "SELECT * FROM T_VrsReport_sum ${ew.customSqlSegment} order by 'startDate' ASC \n" +
            "truncate table T_VrsReport_sum")*/
    /*@Select("Exec _PCcompensation '${liaohao}'\n"+
            "SELECT * XinYe ${ew.customSqlSegment} order by 'startDate' ASC \n")
    List<>*/
/*    @Select({ "call ReportPlatform._PCcompensation('${liucheng}')"
    })

    List<TVrsReport> selectList(@Param("ew") QueryWrapper wrapper, @Param("liucheng")String liucheng);*/




/*    int insert(JiSuan1 jiSuan1);
    List<JiSuan1> selectList(@Param(Constants.WRAPPER) Wrapper wrapper);
    int deleteById(Serializable id);
    int updateById(@Param(Constants.ENTITY) JiSuan1 m);*/
}

