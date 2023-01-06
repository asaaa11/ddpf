package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@AllArgsConstructor
@NoArgsConstructor
@Data
/*@CrossOrigin*/
@TableName("XinZenXuQiu1")
public class XuQiu1 {
   /* @TableId(type = IdType.AUTO)*/
    private Integer id;
    private String biaoMian;
    private String saiKong;
    private Float minHouDu;
    private Float macHouDu;

 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public String getBiaoMian() {
  return biaoMian;
 }

 public void setBiaoMian(String biaoMian) {
  this.biaoMian = biaoMian;
 }

 public String getSaiKong() {
  return saiKong;
 }

 public void setSaiKong(String saiKong) {
  this.saiKong = saiKong;
 }

 public Float getMinHouDu() {
  return minHouDu;
 }

 public void setMinHouDu(Float minHouDu) {
  this.minHouDu = minHouDu;
 }

 public Float getMacHouDu() {
  return macHouDu;
 }

 public void setMacHouDu(Float macHouDu) {
  this.macHouDu = macHouDu;
 }

 public Float getNeiBuYaoQiu() {
  return neiBuYaoQiu;
 }

 public void setNeiBuYaoQiu(Float neiBuYaoQiu) {
  this.neiBuYaoQiu = neiBuYaoQiu;
 }

 private Float neiBuYaoQiu;
  /*  private String neibuyaoqiu;*/
    /*private Date shijian;*/
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
