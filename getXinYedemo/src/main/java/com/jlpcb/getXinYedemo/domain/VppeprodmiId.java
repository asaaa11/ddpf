package com.jlpcb.getXinYedemo.domain;

import lombok.Data;

import java.io.Serializable;


//第三窗数据的查询Id

@Data
public class VppeprodmiId implements Serializable {


    private Long techID;


    private Long flowID;

}