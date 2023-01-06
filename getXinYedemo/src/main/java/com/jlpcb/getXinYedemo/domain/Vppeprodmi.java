package com.jlpcb.getXinYedemo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName vppeprodmi
 */
//第三窗数据
@TableName(value ="vppeprodmi")
@Data
public class Vppeprodmi implements Serializable {
    /**
     * 
     */
    @TableField(value = "TechID")
    private Long techID;

    /**
     * 
     */
    @TableField(value = "MIName")
    private String MIName;

    /**
     * 
     */
    @TableField(value = "DataType")
    private String dataType;

    /**
     * 
     */
    @TableField(value = "MinVal")
    private String minVal;

    /**
     * 
     */
    @TableField(value = "MaxVal")
    private String maxVal;

    /**
     * 
     */
    @TableField(value = "DefVal")
    private String defVal;

    /**
     * 
     */
    @TableField(value = "ShowIndex")
    private Integer showIndex;

    /**
     * 
     */
    @TableField(value = "MIMouldID")
    private Long MIMouldID;

    /**
     * 
     */
    @TableField(value = "ProdMiID")
    private Long prodMiID;

    /**
     * 
     */
    @TableField(value = "FlowID")
    private Long flowID;

    /**
     * 
     */
    @TableField(value = "MiData")
    private String miData;

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
    @TableField(value = "State")
    private Long state;

    /**
     * 
     */
    @TableField(value = "Version")
    private Long version;

    /**
     * 
     */
    @TableField(value = "Remark")
    private String remark;

    /**
     * 
     */
    @TableField(value = "Format")
    private String format;

    /**
     * 
     */
    @TableField(value = "Type")
    private String type;

    /**
     * 
     */
    @TableField(value = "AllowBlank")
    private Boolean allowBlank;

    /**
     * 
     */
    @TableField(value = "Script")
    private String script;

    /**
     * 
     */
    @TableField(value = "BomMouldID")
    private Long bomMouldID;

    /**
     * 
     */
    @TableField(value = "MatType")
    private String matType;

    /**
     * 
     */
    @TableField(value = "AllowReplace")
    private Boolean allowReplace;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}