package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("JiSuan1")
public class JiSuan1 {
    private Integer id;
    private String liaohao;
    private Float kongmin;
    private Float kongz;
    private Float banhou;
    private String biaomian;
    private Float minhou;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLiaohao() {
        return liaohao;
    }

    public void setLiaohao(String liaohao) {
        this.liaohao = liaohao;
    }

    public Float getKongmin() {
        return kongmin;
    }

    public void setKongmin(Float kongmin) {
        this.kongmin = kongmin;
    }

    public Float getKongz() {
        return kongz;
    }

    public void setKongz(Float kongz) {
        this.kongz = kongz;
    }

    public Float getBanhou() {
        return banhou;
    }

    public void setBanhou(Float banhou) {
        this.banhou = banhou;
    }

    public String getBiaomian() {
        return biaomian;
    }

    public void setBiaomian(String biaomian) {
        this.biaomian = biaomian;
    }

    public Float getMinhou() {
        return minhou;
    }

    public void setMinhou(Float minhou) {
        this.minhou = minhou;
    }

    public Float getMincheng() {
        return mincheng;
    }

    public void setMincheng(Float mincheng) {
        this.mincheng = mincheng;
    }

    public String getSaikong() {
        return saikong;
    }

    public void setSaikong(String saikong) {
        this.saikong = saikong;
    }

    public String getHoudu() {
        return houdu;
    }

    public void setHoudu(String houdu) {
        this.houdu = houdu;
    }

    public String getMianqiu() {
        return mianqiu;
    }

    public void setMianqiu(String mianqiu) {
        this.mianqiu = mianqiu;
    }

    public String getXianbie() {
        return xianbie;
    }

    public void setXianbie(String xianbie) {
        this.xianbie = xianbie;
    }

    public Float getChang() {
        return chang;
    }

    public void setChang(Float chang) {
        this.chang = chang;
    }

    public Float getKuan() {
        return kuan;
    }

    public void setKuan(Float kuan) {
        this.kuan = kuan;
    }

    public Double getDiandu() {
        return diandu;
    }

    public void setDiandu(Double diandu) {
        this.diandu = diandu;
    }

    private Float mincheng;
    private String saikong;
    private String houdu;
    private String mianqiu;
    private String xianbie;
    private Float chang;
    private Float kuan;
    private Double diandu;
}



/*

@AllArgsConstructor
@NoArgsConstructor
@Data
*/
/*@CrossOrigin*//*

@TableName("XinZenXuQiu1")
public class XuQiu1 {
    */
/* @TableId(type = IdType.AUTO)*//*

    private Integer id;
    private String biaoMian;
    private String saiKong;
    private Float minHouDu;
    private Float macHouDu;
    private String neiBuYaoQiu;
    */
/*  private String neibuyaoqiu;*//*

    */
/*private Date shijian;*//*

}*/
