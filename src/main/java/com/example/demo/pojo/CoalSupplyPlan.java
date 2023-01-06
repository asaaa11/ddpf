package com.example.demo.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class CoalSupplyPlan extends BaseRowModel {

    private Integer setUnitQty;
    private Long id;
    @Excel(name = "厂内料号")
    private String partNo;
    private String cardNo;
    private String lotNo;
    @Excel( name = "层别")
    private String layers;
    @Excel(name = "PNL数")
    private Long panelQty;
    @Excel(name = "SET数")
    private Long setQty;
    @Excel(name = "PCS数")
    private Long pcsQty;
    @Excel(name = "良品PNL数")
    private Long good_PanelQty;
    @Excel(name = "PNL良率")
    private Double good_PanelRate;
    @Excel(name = "良品SET数")
    private Long good_SetQty;
    @Excel(name = "SET良率")
    private Double good_SetRate;
    @Excel(name = "良品PCS数")
    private Long good_PcsQty;
    @Excel(name = "PCS良率")
    private Double good_PcsRate;
    @Excel(name = "不良点数")
    private Long fail_TotalQty;
    @Excel(name = "SET不良率")
    private Double fail_SetRate;
    @Excel(name = "PCS不良率")
    private Double fail_PcsRate;
    @Excel(name = "PNL不良数")
    private Long fail_PanelQty;
    @Excel(name = "SET不良数")
    private Long fail_SetQty;
    private Long fail_PcsQty;
    @Excel(name = "开路")
    private Long bad1;
    @Excel(name = "短路")
    private Long bad2;
    @Excel(name = "残铜")
    private Long bad3;
    @Excel(name = "蚀刻不净")
    private Long bad4;
    @Excel(name = "缺口")
    private Long bad5;
    @Excel(name = "凹陷")
    private Long bad6;
    @Excel(name = "油墨刮伤")
    private Long bad7;
    @Excel(name = "曝光不良短路")
    private Long bad8;
    @Excel(name = "线细")
    private Long bad9;
    @Excel(name = "显影不洁")
    private Long bad10;
    @Excel(name = "去膜不净")
    private Long bad11;
    @Excel(name = "其它")
    private Long bad12;
    private Long bad13;
    private Long bad14;
    private Long bad15;
    private Long bad16;
    private Long bad17;
    private Long bad18;
    private Long bad19;
    private Long bad20;
    private Long bad21;
    private Long bad22;
    private Long bad23;
    @Excel(name = "操作开始时间")
    private java.sql.Timestamp startDate;
    @Excel(name = "操作结束时间")
    private java.sql.Timestamp endDate;
    @Excel(name = "操作员")
    private String userName;
    @Excel(name = "外层")
    private Boolean isOuter;
    private java.sql.Timestamp Ddate;
}