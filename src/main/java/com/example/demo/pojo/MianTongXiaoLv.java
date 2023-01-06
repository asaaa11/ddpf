package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("MianTongXiaoLv")
public class MianTongXiaoLv {
    @TableId
    private String id;//主键id
    private String holes;//总孔数
    private String holesmin;//最小孔
    private String Mbanhou;//板厚
    private String Mkind;//线别
    private Float miantonglv;//面铜效率
    private String remark;//备注
}
