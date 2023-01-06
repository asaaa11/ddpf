package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("XinZenXuQiu2")
public class XuQiu2 {
    /*@TableId(type = IdType.AUTO)*/
    private Integer id;
    private String biaomian;
    private String liucheng;
    private Float buchang;
   /* private Date shijian;*/
}
