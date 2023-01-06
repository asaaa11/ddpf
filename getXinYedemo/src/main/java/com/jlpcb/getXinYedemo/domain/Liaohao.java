package com.jlpcb.getXinYedemo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Liaohao implements Serializable {
    //料号前面2个字母加中间7位数字
    String ProdNo;
    //中间7位数字的第1个数字，用于判断厚度
    Integer lhd;
    //后缀第一个字母
    String ProdVer;
    //后缀第一个字母后面的数字
    Integer InnerVer;
    //后缀最后一个字母，如HP1131022A2-A
    String ABMark;

    public Liaohao() {
    }

    public Liaohao(String prodVer, Integer innerVer, String ABMark) {
        ProdVer = prodVer;
        InnerVer = innerVer;
        this.ABMark = ABMark;
    }
}
