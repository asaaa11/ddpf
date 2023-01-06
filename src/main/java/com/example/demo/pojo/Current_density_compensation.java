package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("Current_density_compensation")
public class Current_density_compensation {
    @TableId
    private String id;//主键id
    private String holes;//总孔数
    private String Ckind;//线别
    private Float compensation;//电流密度补偿
    private String holesmin;//最小孔
    private String Cbanhou;//板厚
    private String remark;//备注
}
