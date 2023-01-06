
package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.*;
import com.example.demo.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JiSuan1Service {

   @Autowired
    private XinYeMapper xinYeMapper;
    public int qiche(String liaohao){
        XinYe xinYe=new XinYe();
        QueryWrapper<XinYe> wrapper=new QueryWrapper<>();
        wrapper.eq("liaohao",liaohao);
        xinYe=xinYeMapper.selectOne(wrapper);
      return xinYe.getQiche();
    }
/*
    XinYe xinYe=new XinYe();
   */
/* @Autowired
    private XinYeMapper xinYeMapper;
    public XinYe LiaoHao(String liaohao){
        QueryWrapper<XinYe> wrapper=new QueryWrapper<>();
        wrapper.eq("liaohao",liaohao);
        xinYe=xinYeMapper.selectOne(wrapper);
        return xinYe;
    }*//*


    float a;
    float b;
    float c;
    float e;
    float f;
    float g;
    float h;
    List list=null;
    @Autowired
    private XinYeMapper xinYeMapper;
    public XinYe LiaoHao(String liaohao){
       QueryWrapper<XinYe> wrapper=new QueryWrapper<>();
          wrapper.eq("liaohao",liaohao);
          xinYe=xinYeMapper.selectOne(wrapper);
          return xinYe;
    }


    @Autowired
    private LiuZiJingMapper liuZiJingMapper;
    public float HouDu(){
        LiuZiJing liuZiJing=new LiuZiJing();
        QueryWrapper<LiuZiJing> wrapper=new QueryWrapper<>();
        wrapper.eq("ditong",xinYe.getHoudu());
        liuZiJing=liuZiJingMapper.selectOne(wrapper);
        e=liuZiJing.getHoudu();
        return e;
    }


    @Autowired
    private Current_density_compensationMapper mapper;
    public List<Current_density_compensation> select(){
        QueryWrapper wrapper=new QueryWrapper<Current_density_compensation>();
        list = mapper.selectList(wrapper);
        return list;
    }


   @Autowired
    private Current_density_compensationMapper current_density_compensationMapper;
    public float DianLiu(){
        select();
        Current_density_compensation compensation=new Current_density_compensation();
        QueryWrapper<Current_density_compensation> wrapper=new QueryWrapper<>();
        String s="";
        String z="";
        for(int i=0;i<list.size();i++) {
           compensation= (Current_density_compensation) list.get(i);
            String str = compensation.getCbanhou();
            String ztr = compensation.getHoles();
            if (str.contains("≤")) {
                String str1 = str.substring(0, str.indexOf("≤"));
                String str2 = str.substring(str1.length() + 1, str.length());
                float a = Float.parseFloat(str2);
                if (xinYe.getLbanhou() <= a) {
                    s = String.valueOf(xinYe.getLbanhou());
                    s = str;
                }
            }
            if (str.contains("-")) {
                String str1 = str.substring(0, str.indexOf("-"));//之前
                float a = Float.parseFloat(str1);

                String str2 = str.substring(str1.length() + 1, str.length());//之后
                float b = Float.parseFloat(str2);
                if (xinYe.getLbanhou() >= a && xinYe.getLbanhou() >= b) {
                    s = String.valueOf(xinYe.getLbanhou());
                    s = str;
                }
            }
            if (ztr.contains("≤")) {
                String str1 = ztr.substring(0, str.indexOf("≤"));
                String str2 = ztr.substring(str1.length() + 1, str.length());
                float a = Float.parseFloat(str2);
                if (xinYe.getLbanhou() <= a) {
                    s = String.valueOf(xinYe.getLbanhou());
                    s = ztr;
                }
            }
            if (ztr.contains(">")) {
                String str1 = ztr.substring(0, str.indexOf("≤"));
                String str2 = ztr.substring(str1.length() + 1, str.length());
                float a = Float.parseFloat(str2);
                if (xinYe.getLbanhou() <= a) {
                    s = String.valueOf(xinYe.getLbanhou());
                    s = ztr;
                }
            }
            if (ztr.contains("≥")) {
                String str1 = ztr.substring(0, str.indexOf("≤"));
                String str2 = ztr.substring(str1.length() + 1, str.length());
                float a = Float.parseFloat(str2);
                if (xinYe.getLbanhou() <= a) {
                    s = String.valueOf(xinYe.getLbanhou());
                    s = ztr;
                }
            }
        }
        wrapper.eq("Ckind",xinYe.getXianbie())
                .eq("Cbanhou",s)
                .eq("holes",z);
        compensation=current_density_compensationMapper.selectOne(wrapper);
        a= compensation.getCompensation();
        return a;
      }


    @Autowired
    private XuQiu2Mapper xuQiu2Mapper;
    public float BuChang(){
        XuQiu2 xuQiu2=new XuQiu2();
        QueryWrapper<XuQiu2> wrapper= new QueryWrapper<>();
        wrapper.eq("biaomian",xinYe.getBiaomian())
                .eq("liucheng",xinYe.getLiucheng());
                xuQiu2=xuQiu2Mapper.selectOne(wrapper);
                b=xuQiu2.getBuchang();
                System.out.println(b);
              return  b;
    }
    @Autowired
    private XuQiu1Mapper xuQiu1Mapper;
    public  float KongQiu(){
        XuQiu1 xuQiu1=new XuQiu1();
        QueryWrapper<XuQiu1> wrapper=new QueryWrapper<>();
        wrapper.eq("biaoMian",xinYe.getBiaomian())
                .eq("saiKong",xinYe.getSaikong())
                .eq("minHouDu",xinYe.getMinhou())
                .eq("macHouDu",xinYe.getMincheng());
        xuQiu1=xuQiu1Mapper.selectOne(wrapper);
        c=xuQiu1.getNeiBuYaoQiu();
        return  c;
    }


    @Autowired
    private  MianTongXiaoLvMapper mianTongXiaoLvMapper;
    public List<MianTongXiaoLv> select1(){
        QueryWrapper wrapper=new QueryWrapper<Current_density_compensation>();
       list= mianTongXiaoLvMapper.selectList(wrapper);
       return list;
    }
    @Autowired
    public float Mianlv(){
        select1();
        MianTongXiaoLv mianTongXiaoLv=new MianTongXiaoLv();
        String s="";
        for(int i=0;i<list.size();i++) {
            mianTongXiaoLv= (MianTongXiaoLv) list.get(i);
            String str=mianTongXiaoLv.getMbanhou();
            if (str.contains("≤")) {
                String str1 = str.substring(0, str.indexOf("≤"));
                String str2 = str.substring(str1.length() + 1, str.length());
                float a = Float.parseFloat(str2);
                System.out.println(a);
                if (xinYe.getLbanhou() <= a) {
                    s = String.valueOf(xinYe.getLbanhou());
                    s = str;
                }
            }
            if (str.contains(">")) {
                String str1 = str.substring(0, str.indexOf("≤"));
                String str2 = str.substring(str1.length() + 1, str.length());
                float a = Float.parseFloat(str2);
                if (xinYe.getLbanhou() <= a) {
                    s = String.valueOf(xinYe.getLbanhou());
                    s = str;
                }
            }
            if (str.contains("-")) {
                String str1 = str.substring(0, str.indexOf("-"));//之前
                float a = Float.parseFloat(str1);

                String str2 = str.substring(str1.length() + 1, str.length());//之后
                float b = Float.parseFloat(str2);
                if (xinYe.getLbanhou() >= a && xinYe.getLbanhou() >= b) {
                    s = String.valueOf(xinYe.getLbanhou());
                    s = str;
                }
            }
        }
        QueryWrapper<MianTongXiaoLv> wrapper=new QueryWrapper<>();
        wrapper.eq("Mkind",xinYe.getXianbie())
                .eq("Mbanhou",s);
        mianTongXiaoLv=mianTongXiaoLvMapper.selectOne(wrapper);
        f=mianTongXiaoLv.getMiantonglv();
        return f;
    }



    @Autowired
    private Tp_valueMapper tp_valueMapper;
    public List<Tp_value> select2(){
        QueryWrapper wrapper=new QueryWrapper<Tp_value>();
        list= tp_valueMapper.selectList(wrapper);
        return list;
    }
    @Autowired
    public float TpValue() {
        select2();
        Tp_value tp_value = new Tp_value();
        String s = "";
        String z = "";
        String str = tp_value.getTbanhou();
        String ztr = tp_value.getHolesmin();
        for (int i = 0; i < list.size(); i++) {
            tp_value= (Tp_value) list.get(i);
            if (str.contains("≤")) {
                String str1 = str.substring(0, str.indexOf("≤"));
                String str2 = str.substring(str1.length() + 1, str.length());
                float a = Float.parseFloat(str2);
                if (xinYe.getLbanhou() <= a) {
                    s = String.valueOf(xinYe.getLbanhou());
                    s = str;
                }
            }
            if (str.contains("-")) {
                String str1 = str.substring(0, str.indexOf("-"));//之前
                float a = Float.parseFloat(str1);

                String str2 = str.substring(str1.length() + 1, str.length());//之后
                float b = Float.parseFloat(str2);
                if (xinYe.getLbanhou() >= a && xinYe.getLbanhou() >= b) {
                    s = String.valueOf(xinYe.getLbanhou());
                    s = str;
                }
            }
            if (ztr.contains("≤")) {
                String str1 = ztr.substring(0, str.indexOf("≤"));
                String str2 = ztr.substring(str1.length() + 1, str.length());
                float a = Float.parseFloat(str2);
                if (xinYe.getLbanhou() <= a) {
                    s = String.valueOf(xinYe.getLbanhou());
                    s = ztr;
                }
            }
            if (ztr.contains(">")) {
                String str1 = ztr.substring(0, str.indexOf("≤"));
                String str2 = ztr.substring(str1.length() + 1, str.length());
                float a = Float.parseFloat(str2);
                if (xinYe.getLbanhou() <= a) {
                    s = String.valueOf(xinYe.getLbanhou());
                    s = ztr;
                }
            }
            if (ztr.contains("≥")) {
                String str1 = ztr.substring(0, str.indexOf("≤"));
                String str2 = ztr.substring(str1.length() + 1, str.length());
                float a = Float.parseFloat(str2);
                if (xinYe.getLbanhou() <= a) {
                    s = String.valueOf(xinYe.getLbanhou());
                    s = ztr;
                }
            }
        }
            QueryWrapper<Tp_value> wrapper = new QueryWrapper<>();
            wrapper.eq("Tkind", xinYe.getXianbie())
                    .eq("Tbanhou", s)
                    .eq("holesmin", z);
            tp_value = tp_valueMapper.selectOne(wrapper);
            g = tp_value.getTp_value();
            return g;
        }

    public float YaoQiu() {
       XinYe xinYe=new XinYe();
       QueryWrapper<XinYe> wrapper=new QueryWrapper<>();
       wrapper.eq("liaohao",xinYe.getLiaohao())
               .eq("kongmin",xinYe.getKongmin())
               .eq("kongz",xinYe.getKongz())
               .eq("Lbanhou",xinYe.getLbanhou());
                 xinYe=xinYeMapper.selectOne(wrapper);
        h=xinYe.getMianqiu();
           return  h;
    }

    public double DiTong(){
        float kongqiu=c;
        float mianlv=f;
        float buChang=a;
        float tpValue=g;
        float mianqiu=h+b;
        float diTong=e;
       double x=(kongqiu+1.5)/40/0.21/(mianlv-buChang)/tpValue;
       double y=(mianqiu+1.0-diTong)/40/0.21/(mianlv-buChang);
       double z=(Math.max(x,y))*100;
       System.out.println(z);
       return z;
   }
*/

}


