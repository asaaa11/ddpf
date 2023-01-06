package demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName vcprep
 */
@TableName(value ="vcprep")
@Data
public class Vcprep implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 
     */
    @TableField(value = "liaohao")
    private String liaohao;

    /**
     * 
     */
    @TableField(value = "LOT_NO")
    private String LOT_NO;

    /**
     * 
     */
    @TableField(value = "width")
    private String width;

    /**
     * 
     */
    @TableField(value = "height")
    private String height;

    /**
     * 
     */
    @TableField(value = "Plate_thickness")
    private String plate_thickness;

    /**
     * 
     */
    @TableField(value = "Copper_plating_time")
    private String copper_plating_time;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive1")
    private String ch_ASD_positive1;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive2")
    private String ch_ASD_positive2;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive3")
    private String ch_ASD_positive3;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive4")
    private String ch_ASD_positive4;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive5")
    private String ch_ASD_positive5;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive6")
    private String ch_ASD_positive6;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive7")
    private String ch_ASD_positive7;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive8")
    private String ch_ASD_positive8;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive9")
    private String ch_ASD_positive9;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive10")
    private String ch_ASD_positive10;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive11")
    private String ch_ASD_positive11;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive12")
    private String ch_ASD_positive12;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive13")
    private String ch_ASD_positive13;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive14")
    private String ch_ASD_positive14;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive15")
    private String ch_ASD_positive15;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive16")
    private String ch_ASD_positive16;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive17")
    private String ch_ASD_positive17;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive18")
    private String ch_ASD_positive18;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive19")
    private String ch_ASD_positive19;

    /**
     * 
     */
    @TableField(value = "ch_ASD_positive20")
    private String ch_ASD_positive20;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind1")
    private String ch_ASD_behind1;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind2")
    private String ch_ASD_behind2;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind3")
    private String ch_ASD_behind3;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind4")
    private String ch_ASD_behind4;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind5")
    private String ch_ASD_behind5;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind6")
    private String ch_ASD_behind6;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind7")
    private String ch_ASD_behind7;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind8")
    private String ch_ASD_behind8;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind9")
    private String ch_ASD_behind9;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind10")
    private String ch_ASD_behind10;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind11")
    private String ch_ASD_behind11;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind12")
    private String ch_ASD_behind12;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind13")
    private String ch_ASD_behind13;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind14")
    private String ch_ASD_behind14;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind15")
    private String ch_ASD_behind15;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind16")
    private String ch_ASD_behind16;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind17")
    private String ch_ASD_behind17;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind18")
    private String ch_ASD_behind18;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind19")
    private String ch_ASD_behind19;

    /**
     * 
     */
    @TableField(value = "ch_ASD_behind20")
    private String ch_ASD_behind20;
    private  String cycle_time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Vcprep other = (Vcprep) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLiaohao() == null ? other.getLiaohao() == null : this.getLiaohao().equals(other.getLiaohao()))
            && (this.getLOT_NO() == null ? other.getLOT_NO() == null : this.getLOT_NO().equals(other.getLOT_NO()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getPlate_thickness() == null ? other.getPlate_thickness() == null : this.getPlate_thickness().equals(other.getPlate_thickness()))
            && (this.getCopper_plating_time() == null ? other.getCopper_plating_time() == null : this.getCopper_plating_time().equals(other.getCopper_plating_time()))
            && (this.getCh_ASD_positive1() == null ? other.getCh_ASD_positive1() == null : this.getCh_ASD_positive1().equals(other.getCh_ASD_positive1()))
            && (this.getCh_ASD_positive2() == null ? other.getCh_ASD_positive2() == null : this.getCh_ASD_positive2().equals(other.getCh_ASD_positive2()))
            && (this.getCh_ASD_positive3() == null ? other.getCh_ASD_positive3() == null : this.getCh_ASD_positive3().equals(other.getCh_ASD_positive3()))
            && (this.getCh_ASD_positive4() == null ? other.getCh_ASD_positive4() == null : this.getCh_ASD_positive4().equals(other.getCh_ASD_positive4()))
            && (this.getCh_ASD_positive5() == null ? other.getCh_ASD_positive5() == null : this.getCh_ASD_positive5().equals(other.getCh_ASD_positive5()))
            && (this.getCh_ASD_positive6() == null ? other.getCh_ASD_positive6() == null : this.getCh_ASD_positive6().equals(other.getCh_ASD_positive6()))
            && (this.getCh_ASD_positive7() == null ? other.getCh_ASD_positive7() == null : this.getCh_ASD_positive7().equals(other.getCh_ASD_positive7()))
            && (this.getCh_ASD_positive8() == null ? other.getCh_ASD_positive8() == null : this.getCh_ASD_positive8().equals(other.getCh_ASD_positive8()))
            && (this.getCh_ASD_positive9() == null ? other.getCh_ASD_positive9() == null : this.getCh_ASD_positive9().equals(other.getCh_ASD_positive9()))
            && (this.getCh_ASD_positive10() == null ? other.getCh_ASD_positive10() == null : this.getCh_ASD_positive10().equals(other.getCh_ASD_positive10()))
            && (this.getCh_ASD_positive11() == null ? other.getCh_ASD_positive11() == null : this.getCh_ASD_positive11().equals(other.getCh_ASD_positive11()))
            && (this.getCh_ASD_positive12() == null ? other.getCh_ASD_positive12() == null : this.getCh_ASD_positive12().equals(other.getCh_ASD_positive12()))
            && (this.getCh_ASD_positive13() == null ? other.getCh_ASD_positive13() == null : this.getCh_ASD_positive13().equals(other.getCh_ASD_positive13()))
            && (this.getCh_ASD_positive14() == null ? other.getCh_ASD_positive14() == null : this.getCh_ASD_positive14().equals(other.getCh_ASD_positive14()))
            && (this.getCh_ASD_positive15() == null ? other.getCh_ASD_positive15() == null : this.getCh_ASD_positive15().equals(other.getCh_ASD_positive15()))
            && (this.getCh_ASD_positive16() == null ? other.getCh_ASD_positive16() == null : this.getCh_ASD_positive16().equals(other.getCh_ASD_positive16()))
            && (this.getCh_ASD_positive17() == null ? other.getCh_ASD_positive17() == null : this.getCh_ASD_positive17().equals(other.getCh_ASD_positive17()))
            && (this.getCh_ASD_positive18() == null ? other.getCh_ASD_positive18() == null : this.getCh_ASD_positive18().equals(other.getCh_ASD_positive18()))
            && (this.getCh_ASD_positive19() == null ? other.getCh_ASD_positive19() == null : this.getCh_ASD_positive19().equals(other.getCh_ASD_positive19()))
            && (this.getCh_ASD_positive20() == null ? other.getCh_ASD_positive20() == null : this.getCh_ASD_positive20().equals(other.getCh_ASD_positive20()))
            && (this.getCh_ASD_behind1() == null ? other.getCh_ASD_behind1() == null : this.getCh_ASD_behind1().equals(other.getCh_ASD_behind1()))
            && (this.getCh_ASD_behind2() == null ? other.getCh_ASD_behind2() == null : this.getCh_ASD_behind2().equals(other.getCh_ASD_behind2()))
            && (this.getCh_ASD_behind3() == null ? other.getCh_ASD_behind3() == null : this.getCh_ASD_behind3().equals(other.getCh_ASD_behind3()))
            && (this.getCh_ASD_behind4() == null ? other.getCh_ASD_behind4() == null : this.getCh_ASD_behind4().equals(other.getCh_ASD_behind4()))
            && (this.getCh_ASD_behind5() == null ? other.getCh_ASD_behind5() == null : this.getCh_ASD_behind5().equals(other.getCh_ASD_behind5()))
            && (this.getCh_ASD_behind6() == null ? other.getCh_ASD_behind6() == null : this.getCh_ASD_behind6().equals(other.getCh_ASD_behind6()))
            && (this.getCh_ASD_behind7() == null ? other.getCh_ASD_behind7() == null : this.getCh_ASD_behind7().equals(other.getCh_ASD_behind7()))
            && (this.getCh_ASD_behind8() == null ? other.getCh_ASD_behind8() == null : this.getCh_ASD_behind8().equals(other.getCh_ASD_behind8()))
            && (this.getCh_ASD_behind9() == null ? other.getCh_ASD_behind9() == null : this.getCh_ASD_behind9().equals(other.getCh_ASD_behind9()))
            && (this.getCh_ASD_behind10() == null ? other.getCh_ASD_behind10() == null : this.getCh_ASD_behind10().equals(other.getCh_ASD_behind10()))
            && (this.getCh_ASD_behind11() == null ? other.getCh_ASD_behind11() == null : this.getCh_ASD_behind11().equals(other.getCh_ASD_behind11()))
            && (this.getCh_ASD_behind12() == null ? other.getCh_ASD_behind12() == null : this.getCh_ASD_behind12().equals(other.getCh_ASD_behind12()))
            && (this.getCh_ASD_behind13() == null ? other.getCh_ASD_behind13() == null : this.getCh_ASD_behind13().equals(other.getCh_ASD_behind13()))
            && (this.getCh_ASD_behind14() == null ? other.getCh_ASD_behind14() == null : this.getCh_ASD_behind14().equals(other.getCh_ASD_behind14()))
            && (this.getCh_ASD_behind15() == null ? other.getCh_ASD_behind15() == null : this.getCh_ASD_behind15().equals(other.getCh_ASD_behind15()))
            && (this.getCh_ASD_behind16() == null ? other.getCh_ASD_behind16() == null : this.getCh_ASD_behind16().equals(other.getCh_ASD_behind16()))
            && (this.getCh_ASD_behind17() == null ? other.getCh_ASD_behind17() == null : this.getCh_ASD_behind17().equals(other.getCh_ASD_behind17()))
            && (this.getCh_ASD_behind18() == null ? other.getCh_ASD_behind18() == null : this.getCh_ASD_behind18().equals(other.getCh_ASD_behind18()))
            && (this.getCh_ASD_behind19() == null ? other.getCh_ASD_behind19() == null : this.getCh_ASD_behind19().equals(other.getCh_ASD_behind19()))
            && (this.getCh_ASD_behind20() == null ? other.getCh_ASD_behind20() == null : this.getCh_ASD_behind20().equals(other.getCh_ASD_behind20()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLiaohao() == null) ? 0 : getLiaohao().hashCode());
        result = prime * result + ((getLOT_NO() == null) ? 0 : getLOT_NO().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getPlate_thickness() == null) ? 0 : getPlate_thickness().hashCode());
        result = prime * result + ((getCopper_plating_time() == null) ? 0 : getCopper_plating_time().hashCode());
        result = prime * result + ((getCh_ASD_positive1() == null) ? 0 : getCh_ASD_positive1().hashCode());
        result = prime * result + ((getCh_ASD_positive2() == null) ? 0 : getCh_ASD_positive2().hashCode());
        result = prime * result + ((getCh_ASD_positive3() == null) ? 0 : getCh_ASD_positive3().hashCode());
        result = prime * result + ((getCh_ASD_positive4() == null) ? 0 : getCh_ASD_positive4().hashCode());
        result = prime * result + ((getCh_ASD_positive5() == null) ? 0 : getCh_ASD_positive5().hashCode());
        result = prime * result + ((getCh_ASD_positive6() == null) ? 0 : getCh_ASD_positive6().hashCode());
        result = prime * result + ((getCh_ASD_positive7() == null) ? 0 : getCh_ASD_positive7().hashCode());
        result = prime * result + ((getCh_ASD_positive8() == null) ? 0 : getCh_ASD_positive8().hashCode());
        result = prime * result + ((getCh_ASD_positive9() == null) ? 0 : getCh_ASD_positive9().hashCode());
        result = prime * result + ((getCh_ASD_positive10() == null) ? 0 : getCh_ASD_positive10().hashCode());
        result = prime * result + ((getCh_ASD_positive11() == null) ? 0 : getCh_ASD_positive11().hashCode());
        result = prime * result + ((getCh_ASD_positive12() == null) ? 0 : getCh_ASD_positive12().hashCode());
        result = prime * result + ((getCh_ASD_positive13() == null) ? 0 : getCh_ASD_positive13().hashCode());
        result = prime * result + ((getCh_ASD_positive14() == null) ? 0 : getCh_ASD_positive14().hashCode());
        result = prime * result + ((getCh_ASD_positive15() == null) ? 0 : getCh_ASD_positive15().hashCode());
        result = prime * result + ((getCh_ASD_positive16() == null) ? 0 : getCh_ASD_positive16().hashCode());
        result = prime * result + ((getCh_ASD_positive17() == null) ? 0 : getCh_ASD_positive17().hashCode());
        result = prime * result + ((getCh_ASD_positive18() == null) ? 0 : getCh_ASD_positive18().hashCode());
        result = prime * result + ((getCh_ASD_positive19() == null) ? 0 : getCh_ASD_positive19().hashCode());
        result = prime * result + ((getCh_ASD_positive20() == null) ? 0 : getCh_ASD_positive20().hashCode());
        result = prime * result + ((getCh_ASD_behind1() == null) ? 0 : getCh_ASD_behind1().hashCode());
        result = prime * result + ((getCh_ASD_behind2() == null) ? 0 : getCh_ASD_behind2().hashCode());
        result = prime * result + ((getCh_ASD_behind3() == null) ? 0 : getCh_ASD_behind3().hashCode());
        result = prime * result + ((getCh_ASD_behind4() == null) ? 0 : getCh_ASD_behind4().hashCode());
        result = prime * result + ((getCh_ASD_behind5() == null) ? 0 : getCh_ASD_behind5().hashCode());
        result = prime * result + ((getCh_ASD_behind6() == null) ? 0 : getCh_ASD_behind6().hashCode());
        result = prime * result + ((getCh_ASD_behind7() == null) ? 0 : getCh_ASD_behind7().hashCode());
        result = prime * result + ((getCh_ASD_behind8() == null) ? 0 : getCh_ASD_behind8().hashCode());
        result = prime * result + ((getCh_ASD_behind9() == null) ? 0 : getCh_ASD_behind9().hashCode());
        result = prime * result + ((getCh_ASD_behind10() == null) ? 0 : getCh_ASD_behind10().hashCode());
        result = prime * result + ((getCh_ASD_behind11() == null) ? 0 : getCh_ASD_behind11().hashCode());
        result = prime * result + ((getCh_ASD_behind12() == null) ? 0 : getCh_ASD_behind12().hashCode());
        result = prime * result + ((getCh_ASD_behind13() == null) ? 0 : getCh_ASD_behind13().hashCode());
        result = prime * result + ((getCh_ASD_behind14() == null) ? 0 : getCh_ASD_behind14().hashCode());
        result = prime * result + ((getCh_ASD_behind15() == null) ? 0 : getCh_ASD_behind15().hashCode());
        result = prime * result + ((getCh_ASD_behind16() == null) ? 0 : getCh_ASD_behind16().hashCode());
        result = prime * result + ((getCh_ASD_behind17() == null) ? 0 : getCh_ASD_behind17().hashCode());
        result = prime * result + ((getCh_ASD_behind18() == null) ? 0 : getCh_ASD_behind18().hashCode());
        result = prime * result + ((getCh_ASD_behind19() == null) ? 0 : getCh_ASD_behind19().hashCode());
        result = prime * result + ((getCh_ASD_behind20() == null) ? 0 : getCh_ASD_behind20().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", liaohao=").append(liaohao);
        sb.append(", LOT_NO=").append(LOT_NO);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", plate_thickness=").append(plate_thickness);
        sb.append(", copper_plating_time=").append(copper_plating_time);
        sb.append(", ch_ASD_positive1=").append(ch_ASD_positive1);
        sb.append(", ch_ASD_positive2=").append(ch_ASD_positive2);
        sb.append(", ch_ASD_positive3=").append(ch_ASD_positive3);
        sb.append(", ch_ASD_positive4=").append(ch_ASD_positive4);
        sb.append(", ch_ASD_positive5=").append(ch_ASD_positive5);
        sb.append(", ch_ASD_positive6=").append(ch_ASD_positive6);
        sb.append(", ch_ASD_positive7=").append(ch_ASD_positive7);
        sb.append(", ch_ASD_positive8=").append(ch_ASD_positive8);
        sb.append(", ch_ASD_positive9=").append(ch_ASD_positive9);
        sb.append(", ch_ASD_positive10=").append(ch_ASD_positive10);
        sb.append(", ch_ASD_positive11=").append(ch_ASD_positive11);
        sb.append(", ch_ASD_positive12=").append(ch_ASD_positive12);
        sb.append(", ch_ASD_positive13=").append(ch_ASD_positive13);
        sb.append(", ch_ASD_positive14=").append(ch_ASD_positive14);
        sb.append(", ch_ASD_positive15=").append(ch_ASD_positive15);
        sb.append(", ch_ASD_positive16=").append(ch_ASD_positive16);
        sb.append(", ch_ASD_positive17=").append(ch_ASD_positive17);
        sb.append(", ch_ASD_positive18=").append(ch_ASD_positive18);
        sb.append(", ch_ASD_positive19=").append(ch_ASD_positive19);
        sb.append(", ch_ASD_positive20=").append(ch_ASD_positive20);
        sb.append(", ch_ASD_behind1=").append(ch_ASD_behind1);
        sb.append(", ch_ASD_behind2=").append(ch_ASD_behind2);
        sb.append(", ch_ASD_behind3=").append(ch_ASD_behind3);
        sb.append(", ch_ASD_behind4=").append(ch_ASD_behind4);
        sb.append(", ch_ASD_behind5=").append(ch_ASD_behind5);
        sb.append(", ch_ASD_behind6=").append(ch_ASD_behind6);
        sb.append(", ch_ASD_behind7=").append(ch_ASD_behind7);
        sb.append(", ch_ASD_behind8=").append(ch_ASD_behind8);
        sb.append(", ch_ASD_behind9=").append(ch_ASD_behind9);
        sb.append(", ch_ASD_behind10=").append(ch_ASD_behind10);
        sb.append(", ch_ASD_behind11=").append(ch_ASD_behind11);
        sb.append(", ch_ASD_behind12=").append(ch_ASD_behind12);
        sb.append(", ch_ASD_behind13=").append(ch_ASD_behind13);
        sb.append(", ch_ASD_behind14=").append(ch_ASD_behind14);
        sb.append(", ch_ASD_behind15=").append(ch_ASD_behind15);
        sb.append(", ch_ASD_behind16=").append(ch_ASD_behind16);
        sb.append(", ch_ASD_behind17=").append(ch_ASD_behind17);
        sb.append(", ch_ASD_behind18=").append(ch_ASD_behind18);
        sb.append(", ch_ASD_behind19=").append(ch_ASD_behind19);
        sb.append(", ch_ASD_behind20=").append(ch_ASD_behind20);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}