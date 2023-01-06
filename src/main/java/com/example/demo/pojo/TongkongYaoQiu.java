package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("TongkongYaoQiu")
public class TongkongYaoQiu {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String biaomianchuli;
    private Integer dandian;
    private Integer pinjun;
    private Integer feisaikong;
    private Float saikong;
    private String tongmianyaoqiu;
    private String riqi;
    private String remark;
}
