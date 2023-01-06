package com.jlpcb.getXinYedemo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName vppeprodtree
 */
//第一窗数据
@TableName(value ="vppeprodtree")
@Data
public class Vppeprodtree implements Serializable {
    /**
     * 
     */
    @TableField(value = "Id")
    private Long id;

    /**
     * 
     */
    @TableField(value = "leaf")
    private Integer leaf;

    /**
     * 
     */
    @TableField(value = "SurfTreaCaption")
    private String surfTreaCaption;

    /**
     * 
     */
    @TableField(value = "ProdID")
    private Long prodID;

    /**
     * 
     */
    @TableField(value = "ParentID")
    private Long parentID;

    /**
     * 
     */
    @TableField(value = "CustID")
    private Long custID;

    /**
     * 
     */
    @TableField(value = "TargetCustID")
    private Long targetCustID;

    /**
     * 
     */
    @TableField(value = "SurfTreaID")
    private Long surfTreaID;

    /**
     * 
     */
    @TableField(value = "QuoteID")
    private Long quoteID;

    /**
     * 
     */
    @TableField(value = "SpecialtyID")
    private Long specialtyID;

    /**
     * 
     */
    @TableField(value = "Layer")
    private BigDecimal layer;

    /**
     * 
     */
    @TableField(value = "FullProdNo")
    private String fullProdNo;

    /**
     * 
     */
    @TableField(value = "ProdNo")
    private String prodNo;

    /**
     * 
     */
    @TableField(value = "ProdVer")
    private String prodVer;

    /**
     * 
     */
    @TableField(value = "InnerVer")
    private String innerVer;

    /**
     * 
     */
    @TableField(value = "ABMark")
    private String ABMark;

    /**
     * 
     */
    @TableField(value = "InnerSide")
    private String innerSide;

    /**
     * 
     */
    @TableField(value = "CustProdNo")
    private String custProdNo;

    /**
     * 
     */
    @TableField(value = "PNType")
    private String PNType;

    /**
     * 
     */
    @TableField(value = "ProdType")
    private String prodType;

    /**
     * 
     */
    @TableField(value = "Unit")
    private String unit;

    /**
     * 
     */
    @TableField(value = "Currency")
    private String currency;

    /**
     * 
     */
    @TableField(value = "NoTaxPrice")
    private BigDecimal noTaxPrice;

    /**
     * 
     */
    @TableField(value = "ContractPrice")
    private BigDecimal contractPrice;

    /**
     * 
     */
    @TableField(value = "Thick")
    private BigDecimal thick;

    /**
     * 
     */
    @TableField(value = "Weight")
    private BigDecimal weight;

    /**
     * 
     */
    @TableField(value = "SetH")
    private BigDecimal setH;

    /**
     * 
     */
    @TableField(value = "SetW")
    private BigDecimal setW;

    /**
     * 
     */
    @TableField(value = "PCSArea")
    private BigDecimal PCSArea;

    /**
     * 
     */
    @TableField(value = "CustPnl")
    private Boolean custPnl;

    /**
     * 
     */
    @TableField(value = "SheetPnl")
    private Integer sheetPnl;

    /**
     * 
     */
    @TableField(value = "PnlSet")
    private Integer pnlSet;

    /**
     * 
     */
    @TableField(value = "SetPcs")
    private Integer setPcs;

    /**
     * 
     */
    @TableField(value = "ShowOrder")
    private Integer showOrder;

    /**
     * 
     */
    @TableField(value = "HasChild")
    private Boolean hasChild;

    /**
     * 
     */
    @TableField(value = "Remark")
    private String remark;

    /**
     * 
     */
    @TableField(value = "PEActive")
    private Boolean PEActive;

    /**
     * 
     */
    @TableField(value = "MKTActive")
    private Boolean MKTActive;

    /**
     * 
     */
    @TableField(value = "SampPassDate")
    private Date sampPassDate;

    /**
     * 
     */
    @TableField(value = "MassProdDate")
    private Date massProdDate;

    /**
     * 
     */
    @TableField(value = "OdrCount")
    private Integer odrCount;

    /**
     * 
     */
    @TableField(value = "CreateDate")
    private Date createDate;

    /**
     * 
     */
    @TableField(value = "CreateBy")
    private String createBy;

    /**
     * 
     */
    @TableField(value = "UpdateDate")
    private Date updateDate;

    /**
     * 
     */
    @TableField(value = "BomState")
    private Long bomState;

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
    @TableField(value = "CustNo")
    private String custNo;

    /**
     * 
     */
    @TableField(value = "CustName")
    private String custName;

    /**
     * 
     */
    @TableField(value = "CustProdNoAdd")
    private String custProdNoAdd;

    /**
     * 
     */
    @TableField(value = "ConjunctProdNo")
    private String conjunctProdNo;

    /**
     * 
     */
    @TableField(value = "BardType")
    private String bardType;

    /**
     * 
     */
    @TableField(value = "Tg")
    private String tg;

    /**
     * 
     */
    @TableField(value = "CTI")
    private String CTI;

    /**
     * 
     */
    @TableField(value = "IsENV")
    private Boolean isENV;

    /**
     * 
     */
    @TableField(value = "IsConsign")
    private Boolean isConsign;

    /**
     * 
     */
    @TableField(value = "IsFinish")
    private Integer isFinish;

    /**
     * 
     */
    @TableField(value = "TargetName")
    private String targetName;

    /**
     * 
     */
    @TableField(value = "SurfTrea1")
    private String surfTrea1;

    /**
     * 
     */
    @TableField(value = "SurfTrea2")
    private String surfTrea2;

    /**
     * 
     */
    @TableField(value = "HDI")
    private Boolean HDI;

    /**
     * 
     */
    @TableField(value = "HDIStruct")
    private String HDIStruct;

    /**
     * 
     */
    @TableField(value = "HF")
    private Boolean HF;

    /**
     * 
     */
    @TableField(value = "OEM")
    private String OEM;

    /**
     * 
     */
    @TableField(value = "SPC")
    private Boolean SPC;

    /**
     * 
     */
    @TableField(value = "ScrapRate")
    private BigDecimal scrapRate;

    /**
     * 
     */
    @TableField(value = "ECNState")
    private Long ECNState;

    /**
     * 
     */
    @TableField(value = "ECNType")
    private String ECNType;

    /**
     * 
     */
    @TableField(value = "CustUnit")
    private String custUnit;

    /**
     * 
     */
    @TableField(value = "CostPrice")
    private BigDecimal costPrice;

    /**
     * 
     */
    @TableField(value = "CopperThick")
    private BigDecimal copperThick;

    /**
     * 
     */
    @TableField(value = "BlindHole")
    private Boolean blindHole;

    /**
     * 
     */
    @TableField(value = "Flexible")
    private Boolean flexible;

    /**
     * 
     */
    @TableField(value = "IsSafety")
    private Boolean isSafety;

    /**
     * 
     */
    @TableField(value = "QuoteState")
    private Long quoteState;

    /**
     * 
     */
    @TableField(value = "PSWDate")
    private Date PSWDate;

    /**
     * 
     */
    @TableField(value = "THPR")
    private Boolean THPR;

    /**
     * 
     */
    @TableField(value = "IssActive")
    private Boolean issActive;

    /**
     * 
     */
    @TableField(value = "LotActive")
    private Boolean lotActive;

    /**
     * 
     */
    @TableField(value = "PEType")
    private String PEType;

    /**
     * 
     */
    @TableField(value = "PEDifficulty")
    private String PEDifficulty;

    /**
     * 
     */
    @TableField(value = "PESpecial")
    private String PESpecial;

    /**
     * 
     */
    @TableField(value = "PEState")
    private String PEState;

    /**
     * 
     */
    @TableField(value = "PERemark")
    private String PERemark;

    /**
     * 
     */
    @TableField(value = "PEMark")
    private String PEMark;

    /**
     * 
     */
    @TableField(value = "ActiveRemark")
    private String activeRemark;

    /**
     * 
     */
    @TableField(value = "TargetProdNo")
    private String targetProdNo;

    /**
     * 
     */
    @TableField(value = "TargetProdVer")
    private String targetProdVer;

    /**
     * 
     */
    @TableField(value = "PETab")
    private String PETab;

    /**
     * 
     */
    @TableField(value = "PTLQty")
    private Integer PTLQty;

    /**
     * 
     */
    @TableField(value = "PTLRemark")
    private String PTLRemark;

    /**
     * 
     */
    @TableField(value = "TargetCustName")
    private String targetCustName;

    /**
     * 
     */
    @TableField(value = "SOWFileName")
    private String SOWFileName;

    /**
     * 
     */
    @TableField(value = "OtherAdd")
    private String otherAdd;

    /**
     * 
     */
    @TableField(value = "OrgName")
    private String orgName;

    /**
     * 
     */
    @TableField(value = "Features")
    private String features;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}