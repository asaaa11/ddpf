package com.jlpcb.getXinYedemo.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jlpcb.getXinYedemo.domain.*;
import com.jlpcb.getXinYedemo.ex.ServiceException;
import com.jlpcb.getXinYedemo.mapper.VppeprodflowMapper;
import com.jlpcb.getXinYedemo.mapper.VppeprodmiMapper;
import com.jlpcb.getXinYedemo.mapper.VppeprodmidataMapper;
import com.jlpcb.getXinYedemo.mapper.VppeprodtreeMapper;
import com.jlpcb.getXinYedemo.service.IXinYeService;
import com.jlpcb.getXinYedemo.web.ServiceCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service

public class XinYeServiceImpl implements IXinYeService, ServiceCode {
    @Autowired
    private VppeprodtreeMapper vppeprodtreeMapper;
    @Autowired
    private VppeprodflowMapper vppeprodflowMapper;
    @Autowired
    private VppeprodmiMapper vppeprodmiMapper;
    @Autowired
    private VppeprodmidataMapper vppeprodmidataMapper;

    @Override
    public XinYe getNewData(String lh, String xb) {
        Liaohao liaohao = getLihao(lh);
        XinYe xinYe = new XinYe();
        QueryWrapper<Vppeprodtree> qvpt = new QueryWrapper<>();
        if (liaohao.getABMark() == null) {
            qvpt.lambda().eq(Vppeprodtree::getProdNo, liaohao.getProdNo()).eq(Vppeprodtree::getProdVer, liaohao.getProdVer())
                    .eq(Vppeprodtree::getInnerVer, liaohao.getInnerVer());
        } else {
            qvpt.lambda().eq(Vppeprodtree::getProdNo, liaohao.getProdNo()).eq(Vppeprodtree::getProdVer, liaohao.getProdVer())
                    .eq(Vppeprodtree::getInnerVer, liaohao.getInnerVer()).eq(Vppeprodtree::getABMark, liaohao.getABMark());
        }
        List<Vppeprodtree> vppeprodtrees = vppeprodtreeMapper.selectList(qvpt);
        if (vppeprodtrees == null || vppeprodtrees.isEmpty()) {
            String message = "该料号数据不存在";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        //得到料号
        xinYe.setLiaohao(vppeprodtrees.get(0).getFullProdNo());
        //判断是否是汽车板
        String prodType = vppeprodtrees.get(0).getProdType();
        if (prodType.contains("汽车板")) {
            xinYe.setQiche(1);
        } else {
            xinYe.setQiche(2);
        }

        //查询第二窗
        QueryWrapper<Vppeprodflow> qvpf = new QueryWrapper<>();
        qvpf.lambda().eq(Vppeprodflow::getProdID, vppeprodtrees.get(0).getProdID());
        List<Vppeprodflow> approves = vppeprodflowMapper.selectList(qvpf);

        //得到塞孔
        xinYe.setSaikong(getSaikon(approves));
        //得到流程处理
        xinYe.setLiucheng(getLiuchen(approves));
        //得到表面处理
        xinYe.setBiaomian(getBiaomia(approves));


        //得到大于2的厚度,或等于2的厚度 压合厚度(mm)
        if (liaohao.getLhd() > 2) {
            VppeprodmiId yhId = getTwoId(approves, "压合");
            List<Vppeprodmi> miData = getMiData(yhId);

            if (miData == null || miData.isEmpty()) {
                xinYe.setLbanhou(null);
            } else {
                String miNameData = getMiNameData(miData, "压合厚度(mm)");
                xinYe.setLbanhou(Float.parseFloat(miNameData));
            }

        } else if (liaohao.getLhd() == 2) {
            VppeprodmiId klId = getTwoId(approves, "开料");
            List<Vppeprodmidata> miDataDetail = getMiDataDetail(klId);

            if (miDataDetail == null || miDataDetail.isEmpty()) {
                xinYe.setLbanhou(null);
            } else {
                String data2 = miDataDetail.get(0).getData2();
                xinYe.setLbanhou(Float.parseFloat(data2));
            }
        }

        //得到长，宽,原始数据
        List<Float> klckl = getKuanChangMi(approves, "开料");
        List<Float> yhckl = getKuanChangMi(approves, "压合");
        //先通过压合获取，如果压合没有再通过开料获取长宽，判断是否符合规则
        if (yhckl != null && !yhckl.isEmpty()) {
            List<Float> kuanChang1 = getKuanChang(yhckl, xb);
            if (kuanChang1 != null && !kuanChang1.isEmpty()) {
                xinYe.setKuan(kuanChang1.get(0));
                xinYe.setChang(kuanChang1.get(1));
            } else {
                xinYe.setKuan(null);
                xinYe.setChang(null);
            }
        }else if (klckl != null && !klckl.isEmpty()) {
            List<Float> kuanChang1 = getKuanChang(klckl, xb);
            if (kuanChang1 != null && !kuanChang1.isEmpty()) {
                xinYe.setKuan(kuanChang1.get(0));
                xinYe.setChang(kuanChang1.get(1));
            } else {
                xinYe.setKuan(null);
                xinYe.setChang(null);
            }
        }

        //得到最小孔径，总孔数
        VppeprodmiId wczkID = getTwoId(approves, "外层机械钻孔");
        List<Vppeprodmidata> miDataDetail = getMiDataDetail(wczkID);
        if (miDataDetail == null || miDataDetail.isEmpty()) {
            xinYe.setKongmin(null);
            xinYe.setKongz(null);
        } else {
//            List<Float> kjList = new ArrayList<>();
            float sum = 0;
            for (Vppeprodmidata vppeprodmidata : miDataDetail) {
                //data2 数据库用来记录刀径
//                kjList.add(Float.parseFloat(vppeprodmidata.getData2()));
                //data3 数据库用来记录孔数
                sum += Float.parseFloat(vppeprodmidata.getData3());
            }
            //最小孔径
//            Float min = Collections.min(kjList);
//            xinYe.setKongmin(min);
            //总孔数
            xinYe.setKongz(sum);
        }
        //通过纵横比计算最小孔径
        VppeprodmiId ctId = getTwoId(approves, "沉铜");
        List<Vppeprodmi> miData = getMiData(ctId);
        String zhb = getMiNameData(miData, "纵横比");
        if (zhb!=null&&!"".equals(zhb)) {
            List<Float> numFormString = getNumFormString(zhb);
            float v = numFormString.get(0);
            Float bh = xinYe.getLbanhou();
            float v1 = bh / v;
            BigDecimal   b   =   new BigDecimal(v1);
            float v2 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
            System.out.println("最小孔径" + v2);
            xinYe.setKongmin(v2);
        }
        //成品最小孔壁铜厚,成品最小单点铜厚,成品线路铜厚(μm)(最大和最小)
        VppeprodmiId qbddId = getTwoId(approves, "全板电镀");
        List<Vppeprodmi> miData1 = getMiData(qbddId);
        if (miData1 == null || miData1.isEmpty()) {
            xinYe.setMinhou(null);
            xinYe.setMincheng(null);
            xinYe.setMianqiu(null);
        } else {
            String miNameData2 = getMiNameData(miData1, "成品最小孔壁铜厚(μm)");
            List<Float> numFormString = getNumFormString(miNameData2);
            xinYe.setMincheng(Collections.min(numFormString));
            String miNameData3 = getMiNameData(miData1, "成品最小单点铜厚(μm)");
            List<Float> numFormString1 = getNumFormString(miNameData3);
            xinYe.setMinhou(Collections.min(numFormString1));
            String miNameData4 = getMiNameData(miData1, "成品线路铜厚(μm)");
            xinYe.setMianqiu(getMianqi(miNameData4));
            xinYe.setMianqiuMax(getMianqiMax(miNameData4));
        }
        //底铜厚度(oz)
        VppeprodmiId wcgmId = getTwoId(approves, "外层干膜");
        List<Vppeprodmi> miData5 = getMiData(wcgmId);
        if (miData5 == null || miData5.isEmpty()) {
            xinYe.setHoudu(null);
        } else {
            xinYe.setHoudu(getMiNameData(miData5, "底铜厚度(oz)"));
        }

        return xinYe;
    }


    //得到料号
    private Liaohao getLihao(String lh) {
        Liaohao liaohao = new Liaohao();
        if (lh.length() > 11) {
            String pre = lh.substring(0, 9);
            //判断厚度获取位置的数字
            int h;
            char c1 = lh.charAt(2);
            if (Character.isLowerCase(c1) || Character.isUpperCase(c1)) {
                h = 10;
            } else {
                h = Integer.parseInt("" + c1);
            }
            //后缀第一个字母
            String c = "" + lh.charAt(lh.length() - 4);
            //后缀第一个字母后面的数字
            int c2 = Integer.parseInt("" + lh.charAt(lh.length() - 3));
            //-后面的字母
            String c3 = "" + lh.charAt(lh.length() - 1);
            liaohao.setProdNo(pre);
            liaohao.setLhd(h);
            liaohao.setProdVer(c);
            liaohao.setInnerVer(c2);
            liaohao.setABMark(c3);
            return liaohao;
        } else if (lh.length() == 11) {
            String pre = lh.substring(0, 9);
            //判断厚度获取位置的数字
            int h = 0;
            char c1 = lh.charAt(2);
            if (Character.isLowerCase(c1) || Character.isUpperCase(c1)) {
                h = 10;
            } else {
                h = Integer.parseInt("" + c1);
            }
            //后缀第一个字母
            String c = "" + lh.charAt(lh.length() - 2);
            //后缀第一个字母后面的数字
            int c2 = Integer.parseInt("" + lh.charAt(10));
            liaohao.setProdNo(pre);
            liaohao.setProdVer(c);
            liaohao.setInnerVer(c2);
            liaohao.setLhd(h);
            return liaohao;
        } else {
            String message = "料号错误";
            throw new ServiceException(ServiceCode.ERR_BAD_REQUEST, message);
        }
    }

    //得到塞孔
    private String getSaikon(List<Vppeprodflow> vppeprodflowList) {
        for (Vppeprodflow vppeprodflow : vppeprodflowList) {
            if ("树脂塞孔".equals(vppeprodflow.getTechName())) {
                return "树脂塞孔";
            } else if ("铝片塞孔".equals(vppeprodflow.getTechName())) {
                return "铝片塞孔";
            }
        }
        return "非塞孔";
    }

    //得到流程
    private String getLiuchen(List<Vppeprodflow> vppeprodflowList) {
        for (Vppeprodflow vppeprodflow : vppeprodflowList) {
            if ("帽子电镀".equals(vppeprodflow.getTechName())) {
                return "帽子电镀";
            } else if ("树脂塞孔".equals(vppeprodflow.getTechName())) {
                return "树脂塞孔";
            } else if ("陶瓷磨板".equals(vppeprodflow.getTechName())) {
                return "陶瓷磨板";
            }
        }
        return null;
    }

    //得到表面处理
    private String getBiaomia(List<Vppeprodflow> vppeprodflowList) {
        for (Vppeprodflow vppeprodflow : vppeprodflowList) {
            if ("沉金".equals(vppeprodflow.getTechName())) {
                return "沉金/抗氧化";
            } else if ("抗氧化".equals(vppeprodflow.getTechName())||"抗氧化(S)".equals(vppeprodflow.getTechName())) {
                return "沉金/抗氧化";
            } else if ("无铅喷锡".equals(vppeprodflow.getTechName())) {
                return "无铅喷锡/有铅喷锡";
            } else if ("有铅喷锡".equals(vppeprodflow.getTechName())) {
                return "无铅喷锡/有铅喷锡";
            } else if ("沉锡".equals(vppeprodflow.getTechName())) {
                return "沉锡/沉银";
            } else if ("沉银".equals(vppeprodflow.getTechName())) {
                return "沉锡/沉银";
            }
        }
        return null;
    }

    //得到制作流程某项的flowID和techId
    private VppeprodmiId getTwoId(List<Vppeprodflow> secondWin, String tecNam) {
        VppeprodmiId vppeprodmiId = new VppeprodmiId();
        for (Vppeprodflow vppeprodflow : secondWin) {
            if (vppeprodflow.getTechName().equals(tecNam)) {
                vppeprodmiId.setFlowID(vppeprodflow.getFlowID());
                vppeprodmiId.setTechID(vppeprodflow.getTechID());
                return vppeprodmiId;
            }
        }
        return null;
    }

    //得到某工艺名称（制作流程）的项目名称（工程指示）的数据(第三窗)集合
    private List<Vppeprodmi> getMiData(VppeprodmiId vId) {
        if (vId == null) {
            return null;
        }
        QueryWrapper<Vppeprodmi> qvpm = new QueryWrapper<>();
        qvpm.lambda().eq(Vppeprodmi::getFlowID, vId.getFlowID())
                .eq(Vppeprodmi::getTechID, vId.getTechID());

        return vppeprodmiMapper.selectList(qvpm);
    }

    //项目名称（工程指示）的数据(第三窗)
    private String getMiNameData(List<Vppeprodmi> vppeprodmis, String miName) {
        for (Vppeprodmi vppeprodmi : vppeprodmis) {
            if (vppeprodmi.getMIName().equals(miName)) {
                return vppeprodmi.getMiData();
            }
        }
        return null;
    }

    //得到某工艺名称（制作流程）的指示数据（第四窗）
    private List<Vppeprodmidata> getMiDataDetail(VppeprodmiId mddId) {
        if (mddId == null) {
            return null;
        }
        QueryWrapper<Vppeprodmidata> qwww = new QueryWrapper<>();
        qwww.lambda().eq(Vppeprodmidata::getFlowID, mddId.getFlowID());
        return vppeprodmidataMapper.selectList(qwww);
    }

    //成品线路铜厚(μm) 40.3-63.7 取最小
    private Float getMianqi(String s) {
        List<Float> numFormString = getNumFormString(s);
        return Collections.min(numFormString);
    }

    //成品线路铜厚(μm) 40.3-63.7 取最大
    private Float getMianqiMax(String s) {
        List<Float> numFormString = getNumFormString(s);
        if (numFormString != null && !numFormString.isEmpty() && numFormString.size() > 1) {
            return Collections.max(numFormString);
        }
        return null;
    }

    //成品最小孔壁铜厚(μm) 成品最小单点铜厚(μm)
    //20（见备注） 只要数字
    private String getMinchenghou(String s) {

        return s.substring(0, 2);
    }

    //判断某个值是否在某个开区间
    public static boolean rangeInDefined(float current, float min, float max) {
        return Math.max(min, current) == Math.min(current, max);
    }

    //通过沉铜或开料获得长宽的原始数据
    private List<Float> getKuanChangMi(List<Vppeprodflow> secondWin, String tecName) {
        List<Float> ckl = new ArrayList<>();
        VppeprodmiId Id = getTwoId(secondWin, tecName);
        List<Vppeprodmi> miData = getMiData(Id);
        if (miData == null || miData.isEmpty()) {
            return null;
        } else {
            String miNameData;
            String miNameData1;
            if ("沉铜".equals(tecName)) {
                miNameData = getMiNameData(miData, "挂板方向高(mm)");
                miNameData1 = getMiNameData(miData, "挂板方向宽(mm)");
            } else if ("开料".equals(tecName)) {
                miNameData = getMiNameData(miData, "生产尺寸长(mm)");
                miNameData1 = getMiNameData(miData, "生产尺寸宽(mm)");
            } else {
                miNameData = getMiNameData(miData, "切板尺寸长(mm)");
                miNameData1 = getMiNameData(miData, "切板尺寸宽(mm)");
            }
            if (miNameData == null || miNameData1 == null) {
                return null;
            }
            float ag = Float.parseFloat(miNameData);
            float ak = Float.parseFloat(miNameData1);
            ckl.add(ag);
            ckl.add(ak);
            return ckl;
        }
    }

    //获得长宽,集合的第一个元素为宽，第二个元素为长
    private List<Float> getKuanChang(List<Float> fl, String xb) {
        List<Float> ck = new ArrayList<>();
        //取出最大和最小
        Float min = Collections.min(fl);
        Float max = Collections.max(fl);
        boolean b;
        boolean b2;
        boolean b1;
        boolean b3;
        if ("F".equalsIgnoreCase(xb)) {
            b = rangeInDefined(min, 546, 622);
            b1 = rangeInDefined(max, 546, 622);
            b2 = rangeInDefined(max, 622, 725);
            b3 = rangeInDefined(min, 500, 546);
            if (b && b1) {
                ck.add(0, min);
                ck.add(1, max);
            } else if (b && b2) {
                ck.add(0, min);
                ck.add(1, max);
            } else if (b3 && b1) {
                ck.add(0, max);
                ck.add(1, min);
            }
        } else if ("A".equalsIgnoreCase(xb)) {
            b = rangeInDefined(min, 616, 622);
            b2 = rangeInDefined(min, 400, 616);
            b1 = rangeInDefined(max, 616, 622);
            b3 = rangeInDefined(max, 622, 725);
            if (b && b1) {
                ck.add(0, min);
                ck.add(1, max);
            } else if (b2 && b1) {
                ck.add(0, min);
                ck.add(1, max);
            } else if (b && b3) {
                ck.add(0, max);
                ck.add(1, min);
            }
        } else if ("B".equalsIgnoreCase(xb)) {
            b = rangeInDefined(min, 616, 622);
            b2 = rangeInDefined(min, 400, 616);
            b1 = rangeInDefined(max, 616, 622);
            b3 = rangeInDefined(max, 622, 725);
            if (b && b1) {
                ck.add(0, min);
                ck.add(1, max);
            } else if (b2 && b1) {
                ck.add(0, min);
                ck.add(1, max);
            } else if (b && b3) {
                ck.add(0, max);
                ck.add(1, min);
            }
        } else if ("C".equalsIgnoreCase(xb)) {
            b = rangeInDefined(min, 546, 622);
            b1 = rangeInDefined(max, 546, 622);
            b2 = rangeInDefined(max, 622, 725);
            b3 = rangeInDefined(min, 420, 546);
            if (b && b1) {
                ck.add(0, min);
                ck.add(1, max);
            } else if (b && b2) {
                ck.add(0, max);
                ck.add(1, min);
            } else if (b3 && b1) {
                ck.add(0, max);
                ck.add(1, min);
            } else if (b3 && b2) {
                ck.add(0, max);
                ck.add(1, min);
            }
        } else if ("D".equalsIgnoreCase(xb)) {
            b = rangeInDefined(min, 546, 622);
            b1 = rangeInDefined(max, 546, 622);
            b2 = rangeInDefined(max, 622, 725);
            b3 = rangeInDefined(min, 420, 546);
            if (b && b1) {
                ck.add(0, min);
                ck.add(1, max);
            } else if (b && b2) {
                ck.add(0, max);
                ck.add(1, min);
            } else if (b3 && b1) {
                ck.add(0, max);
                ck.add(1, min);
            } else if (b3 && b2) {
                ck.add(0, max);
                ck.add(1, min);
            }
        } else {
            //E线
            b = rangeInDefined(min, 546, 622);
            b1 = rangeInDefined(max, 686, 725);
            if (b && b1) {
                ck.add(0, min);
                ck.add(1, max);
            }
        }
        return ck;
    }

    /**
     * 取出字符串中的整型和浮点型（float）,float超7位会丢失精度
     */
    private List<Float> getNumFormString(String str) {
        String result = str.replaceAll("[^0-9.]", ",");
        String[] split = result.split(",");
        //用StringBuffer来存放数组中的非空元素，用“;”分隔
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            if ("".equals(split[i])) {
                continue;
            }
            sb.append(split[i]);
            if (i != split.length - 1) {
                sb.append(";");
            }
        }
        //用String的split方法分割，得到数组
        split = sb.toString().split(";");
//        return Arrays.asList(split);
		//String类的List转成Float类的List
		return Arrays.stream(split).map(Float::parseFloat).collect(Collectors.toList());
    }

}
