package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("XinYe")
public class XinYe {
    private Integer id;
    private String liaohao;
    private Float kongmin;
    private Float kongz;
    private Float Lbanhou;
    private String biaomian;
    private Float minhou;
    private Float mincheng;
    private String saikong;
    private String houdu;
    private Float mianqiu;
    private String xianbie;
    private Float chang;
    private Float kuan;
    private String liucheng;
    private Integer qiche;

}



/*
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("XinZenXuQiu2")
public class XuQiu2 {
    */
/*@TableId(type = IdType.AUTO)*//*

    private Integer id;
    private String biaomian;
    private String liucheng;
    private String buchang;
    */
/* private Date shijian;*//*

}*/
