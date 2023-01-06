package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("MesTable")
public class MesTable {
    @TableId
    private String pno;//批卡号
    private String job_name;//料号名
    private String top_layer;//元件面名称
    private String bottom_layer;//焊接面名称
    private Float scalex;//元面涨缩系数X
    private Float scaley;//元面涨缩系数Y
    private String tgz_path;//资料文件路径
    private String film_model;//干膜/湿膜型号
    private Float thick;//基板厚度(mm)
    private Integer sizex;//基板板宽(mm)
    private Integer sizey;//基板板高(mm)
    private String equip_no;//设备编号
    private String lot_no;//工单号
    private Float scalex_bottom;//焊面涨缩系数X
    private Float scaley_bottom;//焊面涨缩系数Y
    private String top_polarity;//元面极性
    private String bottom_polarity;//焊面极性
    private String step_name;//Step名称
    private Integer week_stamp;//周期值
    private String plot_no;//批次号
    private String slot_no;//流水号
    private String version_no;//版本号
    private Date date;//日期
}
