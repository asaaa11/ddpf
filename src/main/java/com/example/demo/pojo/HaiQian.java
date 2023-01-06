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
@TableName("HaiQian")
public class HaiQian {
    private String  pdctno;
    private Integer ps;
}




/*
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("liuzijing")
public class LiuZiJing {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Float houdu;
    private String beizhu;
    private String riqi;
    private String ditong;
    private String danwei;
}
*/
