package com.jlpcb.getXinYedemo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName vppeprodflow
 */
//第二窗数据
@TableName(value ="vppeprodflow")
@Data
public class Vppeprodflow implements Serializable {
    /**
     * 
     */
    @TableField(value = "FlowID")
    private Long flowID;

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

    /**
     * 
     */
    @TableField(value = "ShowIndex")
    private Integer showIndex;

    /**
     * 
     */
    @TableField(value = "State")
    private Long state;

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
    @TableField(value = "TechName")
    private String techName;

    /**
     * 
     */
    @TableField(value = "TechType")
    private Integer techType;

    /**
     * 
     */
    @TableField(value = "Remark")
    private String remark;

    /**
     * 
     */
    @TableField(value = "PassOver")
    private Boolean passOver;

    /**
     * 
     */
    @TableField(value = "IPQC")
    private Boolean IPQC;

    /**
     * 
     */
    @TableField(value = "AudBy0")
    private String audBy0;

    /**
     * 
     */
    @TableField(value = "AudBy1")
    private String audBy1;

    /**
     * 
     */
    @TableField(value = "AudBy2")
    private String audBy2;

    /**
     * 
     */
    @TableField(value = "AudBy3")
    private String audBy3;

    /**
     * 
     */
    @TableField(value = "AudBy4")
    private String audBy4;

    /**
     * 
     */
    @TableField(value = "MILinkId")
    private Long MILinkId;

    /**
     * 
     */
    @TableField(value = "SourceProdID")
    private Long sourceProdID;

    /**
     * 
     */
    @TableField(value = "SourceProdNo")
    private String sourceProdNo;

    /**
     * 
     */
    @TableField(value = "SourceProdVer")
    private String sourceProdVer;

    /**
     * 
     */
    @TableField(value = "SourceInnerVer")
    private String sourceInnerVer;

    /**
     * 
     */
    @TableField(value = "SourceABMark")
    private String sourceABMark;

    /**
     * 
     */
    @TableField(value = "SourceInnerSide")
    private String sourceInnerSide;

    /**
     * 
     */
    @TableField(value = "TechRemark")
    private String techRemark;

    /**
     * 
     */
    @TableField(value = "WorkUnit")
    private String workUnit;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}