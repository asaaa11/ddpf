package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.*;
import com.example.demo.service.*;
import com.example.demo.service.impl.VcprepServiceImpl;
import com.example.demo.utils.AjaxResult;
import demo.domain.Vcprep;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo.utils.HttpUtils.sendGet;


@CrossOrigin
@RestController
@MapperScan("com.example.demo.*.mapper")
@RequestMapping("JiSuan1")
@ApiOperation(value = "_PCcompensation", notes = "_PCcompensation")
public class JiSuan1Controller {

    @Autowired
    VcprepServiceImpl vcprepServiceImpl;

    @Autowired
    XinYeService xinYeService;
    @RequestMapping("find")
    public List<demo.domain.Vcprep> select(String liaohao){
        return vcprepServiceImpl.select(liaohao);
    }

    @Autowired
    private JiSuan1Service jiSuan1Service;
    @GetMapping("getDiTong")
    private Map<String,Object> getDiTong(@RequestParam String liaohao) {

        Map<String,Object> retMap=new HashMap<>();
        return retMap;
    }
    public static String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String DB_URL = "jdbc:sqlserver://192.168.153.181:1433;databaseName=ReportPlatform";
    public static String USERNAME = "sa";
    public static String PASSWORD = "Test1234";
    {
        try {
            Class.forName(DB_DRIVER);
            CONN = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("getDiTong1")
    public List<demo.domain.Vcprep> getDiTong1(@RequestParam String liaohao) throws SQLException {

        return vcprepServiceImpl.select(liaohao);
    }
    public  Connection CONN;
    @RequestMapping("jis")
    private Map<String, Object> jis(String liaohao, String gongxu,String xb){
        if (liaohao.equals("HP4666215H1")||liaohao.equals("HP4666215h2")||liaohao.equals("hp4666215h2")){
            return AjaxResult.error( 500,"当前料号已被锁定");
        }
          if (xb.equals("PLC002")){
              xb="E";
          }else if (xb.equals("PLC001")){
              xb="F";
          } else if (xb.equals("PLC003")) {
              xb = "C";
          } else if (xb.equals("PLC004")) {
              xb = "D";
          } else if (xb.equals("PLC005")) {
              xb = "A";
          } else if (xb.equals("PLC006")) {
              xb = "B";
          }
        List<XinYe> list = xinYeService.select(liaohao);
    //当查询结果为空时
        try {

            if(list.size()==0){
                String lh=liaohao;
                String data = JSON.parseObject(sendGet("http://localhost:9527/xinye/get?lh="+lh+"&xb="+xb, null).toString()).getString("data");
                //获取data里面的数据
                XinYe xinYe1 = JSON.parseObject(data, XinYe.class);
                xinYe1.setXianbie(xb);
                Float kuan = xinYe1.getKuan();
                Float chang = xinYe1.getChang();

                System.out.printf(xinYe1.getKongmin().toString());

                xinYeService.insert(xinYe1);
                Vcprep vcprep1 = new Vcprep();
                vcprep1.setLiaohao(liaohao);
                //截取料号HP后面的数字
                String liaohao1 = liaohao.substring(2);
                vcprep1.setLOT_NO(liaohao1);
                xinYeService.insert1(vcprep1);
            }
            System.out.printf("xb"+xb);
            int p=jiSuan1Service.qiche(liaohao);
            double max=0;
            CallableStatement cstat = null;
            int x ;
            int dlsj=40;
            try {
                // 参数中第一个?代表输入参数，第二个表示输出参数
                cstat = CONN.prepareCall("{call _PCcompensation(?,?,?,?,?,?,?,?)}");
                cstat.setString(1, liaohao);
                // 注册输出参数类型
                cstat.registerOutParameter(2, Types.VARCHAR);
                cstat.registerOutParameter(3, Types.VARCHAR);
                cstat.registerOutParameter(4, Types.VARCHAR);
                cstat.registerOutParameter(5, Types.VARCHAR);
                cstat.registerOutParameter(6, Types.VARCHAR);
                cstat.registerOutParameter(7, Types.VARCHAR);
                cstat.registerOutParameter(8, Types.VARCHAR);
                cstat.execute();
                // 获得输出参数值
                String testPrint2 = cstat.getString(2);
                String testPrint3= cstat.getString(3);
                String testPrint4 = cstat.getString(4);
                String testPrint5 = cstat.getString(5);
                String testPrint6 = cstat.getString(6);
                String testPrint7 = cstat.getString(7);
                String testPrint8 = cstat.getString(8);

                Float mianqiu=Float.parseFloat(testPrint2);
                Float compensation=Float.parseFloat(testPrint3);
                Float tp_value=Float.parseFloat(testPrint4);
                Float houdu=Float.parseFloat(testPrint5);
                Float miantonglv=Float.parseFloat(testPrint6);
                Float neibuyaoqiu=Float.parseFloat(testPrint7);
                Float buchang=Float.parseFloat(testPrint8);

            //实现表格中横向和竖向的同时匹配查找 通过料号和工序查找


                if (gongxu=="黑影"||gongxu.equals("黑影")){

                    tp_value=tp_value*0.95f;
                }
                double    aa= mianqiu+buchang+1.0-houdu;
                double    bb= neibuyaoqiu+1.5;
                double    cc= miantonglv-compensation;
                double dd=neibuyaoqiu+2.5;
                double v = bb / 40 / 0.21 / cc / tp_value;
                double v1 = aa / 40 / 0.21 / cc ;
                v=v*10000;
                v1=v1*100;
                //取大
                max = Math.max(v, v1);
                if (xb.equals("A")||xb.equals("B")){
                    if(p==2) {
                        if (xinYeService.select(liaohao).get(0).getKuan() >= 540) {
                            for (int i = 40; max > 3.8; i += 5) {
                                v = bb / i / 0.21 / cc / tp_value;
                                v1 = aa / i / 0.21 / cc ;
                                //取大
                                v= v*10000;
                                v1=v1*100;
                                max = Math.max(v, v1);

                                dlsj= i;
                            }
                        }else if (xinYeService.select(liaohao).get(0).getKuan() >= 477&&xinYeService.select(liaohao).get(0).getKuan() < 540) {
                            dlsj=45;
                            v = bb / 45 / 0.21 / cc / tp_value;
                            v1 = aa / 45 / 0.21 / cc ;
                            //取大
                            v= v*10000;
                            v1=v1*100;
                            max = Math.max(v, v1);

                            for (int i = 45; max > 3.8; i += 5) {
                                v = bb / i / 0.21 / cc / tp_value;
                                v1 = aa / i / 0.21 / cc ;
                                //取大
                                v= v*10000;
                                v1=v1*100;
                                max = Math.max(v, v1);

                                dlsj= i;
                            }
                        }else if (xinYeService.select(liaohao).get(0).getKuan() >= 430&&xinYeService.select(liaohao).get(0).getKuan() < 477) {
                            dlsj=50;

                            v = bb / 50 / 0.21 / cc / tp_value;
                            v1 = aa / 50 / 0.21 / cc ;
                            //取大
                            v= v*10000;
                            v1=v1*100;
                            max = Math.max(v, v1);
                            for (int i = 50; max > 3.8; i += 5) {
                                v = bb / i / 0.21 / cc / tp_value;
                                v1 = aa / i / 0.21 / cc ;
                                //取大
                                v= v*10000;
                                v1=v1*100;
                                max = Math.max(v, v1);

                                dlsj= i;
                            }}else if (xinYeService.select(liaohao).get(0).getKuan() >= 400&&xinYeService.select(liaohao).get(0).getKuan() < 430){
                            dlsj=55;
                            v = bb / 55 / 0.21 / cc / tp_value;
                            v1 = aa / 55 / 0.21 / cc ;
                            //取大
                            v= v*10000;
                            v1=v1*100;
                            max = Math.max(v, v1);
                            for (int i = 55; max > 3.8; i += 5) {
                                v = bb / i / 0.21 / cc / tp_value;
                                v1 = aa / i / 0.21 / cc ;
                                //取大
                                v= v*10000;
                                v1=v1*100;
                                max = Math.max(v, v1);

                                dlsj= i;
                            }}
                    }else {
                        if (xinYeService.select(liaohao).get(0).getKuan() >= 540) {
                            for (int i = 40; max > 3.5; i += 5) {
                                v = bb / i / 0.21 / cc / tp_value;
                                v1 = aa / i / 0.21 / cc ;
                                //取大
                                v= v*10000;
                                v1=v1*100;
                                max = Math.max(v, v1);

                                dlsj= i;
                            }
                        }else if (xinYeService.select(liaohao).get(0).getKuan() >= 477&&xinYeService.select(liaohao).get(0).getKuan() < 540) {
                            dlsj=45;
                            v = bb / 45 / 0.21 / cc / tp_value;
                            v1 = aa / 45 / 0.21 / cc ;
                            //取大
                            v= v*10000;
                            v1=v1*100;
                            max = Math.max(v, v1);
                            for (int i = 45; max > 3.5; i += 5) {
                                v = bb / i / 0.21 / cc / tp_value;
                                v1 = aa / i / 0.21 / cc ;
                                //取大
                                v= v*10000;
                                v1=v1*100;
                                max = Math.max(v, v1);

                                dlsj= i;
                            }
                        }else if (xinYeService.select(liaohao).get(0).getKuan() >= 430&&xinYeService.select(liaohao).get(0).getKuan() < 477) {
                            dlsj=50;
                            v = bb / 50 / 0.21 / cc / tp_value;
                            v1 = aa / 50 / 0.21 / cc ;
                            //取大
                            v= v*10000;
                            v1=v1*100;
                            max = Math.max(v, v1);
                            for (int i = 50; max > 3.5; i += 5) {
                                v = bb / i / 0.21 / cc / tp_value;
                                v1 = aa / i / 0.21 / cc ;
                                //取大
                                v= v*10000;
                                v1=v1*100;
                                max = Math.max(v, v1);

                                dlsj= i;
                            }}else if (xinYeService.select(liaohao).get(0).getKuan() >= 400&&xinYeService.select(liaohao).get(0).getKuan() < 430){
                            dlsj=55;

                            v = bb / 55 / 0.21 / cc / tp_value;
                            v1 = aa / 55 / 0.21 / cc ;
                            //取大
                            v= v*10000;
                            v1=v1*100;
                            max = Math.max(v, v1);
                            for (int i = 55; max > 3.; i += 5) {
                                v = bb / i / 0.21 / cc / tp_value;
                                v1 = aa / i / 0.21 / cc ;
                                //取大
                                v= v*10000;
                                v1=v1*100;
                                max = Math.max(v, v1);

                                dlsj= i;
                            }}
                    }
                }else {
                    if(p==2) {
                        for (int i = 40; max > 3.8; i += 5) {
                            v = bb / i / 0.21 / cc / tp_value;
                            v1 = aa / i / 0.21 / cc ;
                            //取大
                            v= v*10000;
                            v1=v1*100;
                            max = Math.max(v, v1);

                            dlsj= i;
                        }
                    }else {
                        for (int i = 40; max >= 3.5; i += 5) {
                            v = dd / i / 0.21 / cc / tp_value;
                            v1 = aa / i / 0.21 / cc ;

                            //取大
                            v= v*10000;
                            v1=v1*100;


                            max = Math.max(v, v1);


                            dlsj= i;

                        }
                    }
                }

            }catch (SQLException e) {
                e.printStackTrace();
            }
            List<Vcprep> select = vcprepServiceImpl.select(liaohao);
            List<XinYe> select1 = xinYeService.select(liaohao);
            double kuan=0;
            double gao=0;
            double banhou=0;
            for (XinYe xinYe : select1) {
                kuan= xinYe.getKuan();
                gao=xinYe.getChang();
                banhou=xinYe.getLbanhou();
            }

            for (Vcprep vcprep : select) {
                String width = vcprep.getWidth();
                String height = vcprep.getHeight();
                String vbanhou=vcprep.getPlate_thickness();
                width= String.valueOf(kuan);
                height= String.valueOf(gao);
                vbanhou=String.valueOf(banhou);
                //将宽高放入select中
                vcprep.setWidth(width);
                vcprep.setHeight(height);
                    if (xb.equals("C")||xb.equals("D")||xb.equals("E")||xb.equals("F")){
                        String dtsj1=String.valueOf((kuan+8)/60000*dlsj*60);
                        //保留一位小数四舍五入
                        BigDecimal b = new BigDecimal(dtsj1);
                        double dtsj11 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                        int dtsj121= (int) (dtsj11*10);

                        vcprep.setCycle_time(String.valueOf(dtsj121));
    }else {
                        String dtsj1=String.valueOf((kuan+8)/48000*dlsj*60);
                        //保留一位小数四舍五入
                        BigDecimal b = new BigDecimal(dtsj1);
                        double dtsj11 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                        int dtsj121= (int) (dtsj11*10);

                        vcprep.setCycle_time(String.valueOf(dtsj121));
    }
                //判断plate_thickness是否有小数点第3位
                if(vbanhou.indexOf(".")!=-1){
                    //如果有小数点第3位

                    if(vbanhou.length()-vbanhou.indexOf(".")>3){
                        //判断有小数点第3位是否大于8
                        if(vbanhou.charAt(vbanhou.indexOf(".")+3)>='8'){
                            //如果大于8
                            //将小数点第3位加1
                            vbanhou=String.valueOf(Double.parseDouble(vbanhou)+0.01);
                            //将小数点第3位变为0
                            vbanhou=vbanhou.substring(0,vbanhou.indexOf(".")+3)+"0";
                        }else {
                            //如果小于8
                            //将小数点第3位加1
                            vbanhou=String.valueOf(Double.parseDouble(vbanhou));
                            //将小数点第3位变为0
                            vbanhou=vbanhou.substring(0,vbanhou.indexOf(".")+3)+"0";
                        }
                    }
                    vcprep.setPlate_thickness(vbanhou);

                }
                x= (int) (max*100);
                vcprep.setCh_ASD_behind1(String.valueOf(x));
                vcprep.setCh_ASD_behind2(String.valueOf(x));
                vcprep.setCh_ASD_behind3(String.valueOf(x));
                vcprep.setCh_ASD_behind4(String.valueOf(x));
                vcprep.setCh_ASD_behind5(String.valueOf(x));
                vcprep.setCh_ASD_behind6(String.valueOf(x));
                vcprep.setCh_ASD_behind7(String.valueOf(x));
                vcprep.setCh_ASD_behind8(String.valueOf(x));
                vcprep.setCh_ASD_behind9(String.valueOf(x));
                vcprep.setCh_ASD_behind10(String.valueOf(x));
                vcprep.setCh_ASD_behind11(String.valueOf(x));
                vcprep.setCh_ASD_behind12(String.valueOf(x));
                vcprep.setCh_ASD_behind13(String.valueOf(x));
                vcprep.setCh_ASD_behind14(String.valueOf(x));
                vcprep.setCh_ASD_behind15(String.valueOf(x));
                vcprep.setCh_ASD_behind16(String.valueOf(x));
                vcprep.setCh_ASD_behind17(String.valueOf(x));
                vcprep.setCh_ASD_behind18(String.valueOf(x));
                vcprep.setCh_ASD_behind19(String.valueOf(x));
                vcprep.setCh_ASD_behind20(String.valueOf(x));
                vcprep.setCh_ASD_positive1(String.valueOf(x));
                vcprep.setCh_ASD_positive2(String.valueOf(x));
                vcprep.setCh_ASD_positive3(String.valueOf(x));
                vcprep.setCh_ASD_positive4(String.valueOf(x));
                vcprep.setCh_ASD_positive5(String.valueOf(x));
                vcprep.setCh_ASD_positive6(String.valueOf(x));
                vcprep.setCh_ASD_positive7(String.valueOf(x));
                vcprep.setCh_ASD_positive8(String.valueOf(x));
                vcprep.setCh_ASD_positive9(String.valueOf(x));
                vcprep.setCh_ASD_positive10(String.valueOf(x));
                vcprep.setCh_ASD_positive11(String.valueOf(x));
                vcprep.setCh_ASD_positive12(String.valueOf(x));
                vcprep.setCh_ASD_positive13(String.valueOf(x));
                vcprep.setCh_ASD_positive14(String.valueOf(x));
                vcprep.setCh_ASD_positive15(String.valueOf(x));
                vcprep.setCh_ASD_positive16(String.valueOf(x));
                vcprep.setCh_ASD_positive17(String.valueOf(x));
                vcprep.setCh_ASD_positive18(String.valueOf(x));
                vcprep.setCh_ASD_positive19(String.valueOf(x));
                vcprep.setCh_ASD_positive20(String.valueOf(x));
                vcprep.setCopper_plating_time(String.valueOf(dlsj));
            }
            Map<String, Object> map = new HashMap<>();
            map.put("list", select);
            map.put("code",200);
            map.put("msg","查询成功");

            return map ;
        } catch (Exception e) {
            //返回查询失败
            return AjaxResult.error( 500,"当前料号"+xb+"线不可用");
        } finally {

            List<XinYe> select = xinYeService.select(liaohao);

            //遍历select获取id
            int id=0;
            for (XinYe xinYe : select) {
                id=xinYe.getId();
            }

            xinYeService.delete(id);

        }


    }

}



