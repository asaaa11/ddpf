package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("Tp_value")
public class Tp_value {
    @TableId
    private String id;//主键id
    private String holes;//孔数
    private String Tkind;//线别
    private Float tp_value;//TP值
    private String holesmin;//最小孔
    private String Tbanhou;//板厚
    private String remark;//备注
}
