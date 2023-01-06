package com.jlpcb.getXinYedemo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName vppeprodmidata
 */
//第四窗数据
@TableName(value ="vppeprodmidata")
@Data
public class Vppeprodmidata implements Serializable {
    /**
     * 
     */
    @TableField(value = "TechName")
    private String techName;

    /**
     * 
     */
    @TableField(value = "DataID")
    private Long dataID;

    /**
     * 
     */
    @TableField(value = "FlowID")
    private Long flowID;

    /**
     * 
     */
    @TableField(value = "ShowIndex")
    private Integer showIndex;

    /**
     * 
     */
    @TableField(value = "CreateBy")
    private String createBy;

    /**
     * 
     */
    @TableField(value = "CreateDate")
    private Date createDate;

    /**
     * 
     */
    @TableField(value = "UpdateDate")
    private Date updateDate;

    /**
     * 
     */
    @TableField(value = "Version")
    private Long version;

    /**
     * 
     */
    @TableField(value = "Data0")
    private String data0;

    /**
     * 
     */
    @TableField(value = "Data1")
    private String data1;

    /**
     * 
     */
    @TableField(value = "Data2")
    private String data2;

    /**
     * 
     */
    @TableField(value = "Data3")
    private String data3;

    /**
     * 
     */
    @TableField(value = "Data4")
    private String data4;

    /**
     * 
     */
    @TableField(value = "Data5")
    private String data5;

    /**
     * 
     */
    @TableField(value = "Data6")
    private String data6;

    /**
     * 
     */
    @TableField(value = "Data7")
    private String data7;

    /**
     * 
     */
    @TableField(value = "Data8")
    private String data8;

    /**
     * 
     */
    @TableField(value = "Data9")
    private String data9;

    /**
     * 
     */
    @TableField(value = "Data10")
    private String data10;

    /**
     * 
     */
    @TableField(value = "Data11")
    private String data11;

    /**
     * 
     */
    @TableField(value = "Data12")
    private String data12;

    /**
     * 
     */
    @TableField(value = "Data13")
    private String data13;

    /**
     * 
     */
    @TableField(value = "Data14")
    private String data14;

    /**
     * 
     */
    @TableField(value = "Data15")
    private String data15;

    /**
     * 
     */
    @TableField(value = "Data16")
    private String data16;

    /**
     * 
     */
    @TableField(value = "Data17")
    private String data17;

    /**
     * 
     */
    @TableField(value = "Data18")
    private String data18;

    /**
     * 
     */
    @TableField(value = "Data19")
    private String data19;

    /**
     * 
     */
    @TableField(value = "Data20")
    private String data20;

    /**
     * 
     */
    @TableField(value = "Data21")
    private String data21;

    /**
     * 
     */
    @TableField(value = "Data22")
    private String data22;

    /**
     * 
     */
    @TableField(value = "Data23")
    private String data23;

    /**
     * 
     */
    @TableField(value = "Data24")
    private String data24;

    /**
     * 
     */
    @TableField(value = "Data25")
    private String data25;

    /**
     * 
     */
    @TableField(value = "Data26")
    private String data26;

    /**
     * 
     */
    @TableField(value = "Data27")
    private String data27;

    /**
     * 
     */
    @TableField(value = "Data28")
    private String data28;

    /**
     * 
     */
    @TableField(value = "Data29")
    private String data29;

    /**
     * 
     */
    @TableField(value = "Data30")
    private String data30;

    /**
     * 
     */
    @TableField(value = "ProdID")
    private Long prodID;

    /**
     * 
     */
    @TableField(value = "TechID")
    private Long techID;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}