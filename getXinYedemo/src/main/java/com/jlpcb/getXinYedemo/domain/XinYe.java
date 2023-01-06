package com.jlpcb.getXinYedemo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class XinYe implements Serializable {
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
    private Float mianqiuMax;
    private String xianbie;
    private Float chang;
    private Float kuan;
    private String liucheng;
    private Integer qiche;

    public XinYe() {
    }

    public XinYe(Integer id, String liaohao, Float kongmin, Float kongz, Float lbanhou, String biaomian, Float minhou, Float mincheng, String saikong, String houdu, Float mianqiu, Float mianqiuMax, String xianbie, Float chang, Float kuan, String liucheng, Integer qiche) {
        this.id = id;
        this.liaohao = liaohao;
        this.kongmin = kongmin;
        this.kongz = kongz;
        Lbanhou = lbanhou;
        this.biaomian = biaomian;
        this.minhou = minhou;
        this.mincheng = mincheng;
        this.saikong = saikong;
        this.houdu = houdu;
        this.mianqiu = mianqiu;
        this.mianqiuMax = mianqiuMax;
        this.xianbie = xianbie;
        this.chang = chang;
        this.kuan = kuan;
        this.liucheng = liucheng;
        this.qiche = qiche;
    }
}
