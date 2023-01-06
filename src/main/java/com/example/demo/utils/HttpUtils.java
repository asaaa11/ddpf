package com.example.demo.utils;


import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.XinYe;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HttpUtils {

    /**
     * get请求不带参数
     *
     * @param url 访问json数据接口
     * @return
     */
    public static String doGet(String url) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * get请求带参数
     *
     * @param getUrl  访问json数据接口
     * @param paraMap 参数
     * @return
     */
    public static String sendGet(String getUrl, Map<String, String> paraMap) {
        if (paraMap == null) {
            paraMap = new HashMap<>();
        }
        paraMap = new TreeMap<>(paraMap);
        StringBuilder sb = new StringBuilder();
        paraMap.entrySet().stream().forEach(entry -> {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        });
        //发送get请求地址为http://192.168.131.91/proxyapi/dcc/labels

        getUrl = getUrl.contains("?") ? getUrl : getUrl + "?";

        return doGet(getUrl + sb.toString());
    }

    /*public static void main(String[] args) {
        //调用sendGet方法http://192.168.131.91/proxyapi/dcc/labels?current=1&pageSize=120&deviceCode=PLC001&page=1
        Object current = 1;
        Object pageSize = 240;
        Object deviceCode = "PLC001";
        Object page = 1;
        Map<String, String> paraMap = new HashMap<>();
        paraMap.put("current", current.toString());
        paraMap.put("pageSize", pageSize.toString());
        paraMap.put("deviceCode", deviceCode.toString());
        paraMap.put("page", page.toString());
        String data = JSON.parseObject(sendGet("http://192.168.150.143/proxyapi/dcc/labels", paraMap)).getString("data");

        //获取data数据的list集合
        List<Map> list = JSON.parseObject(data).getJSONArray("list").toJavaList(Map.class);
        *//*  System.out.printf("list:"+list);*//*
        Product product = new Product();
        list.stream().forEach(map -> {
                    //判断name前面是否是R  是的话就打印出来
                    if (map.get("name").toString().startsWith("R")) {
                        //去除空格
                        String name = map.get("name").toString().replaceAll(" ", "");
                        String value = map.get("value").toString().replaceAll(" ", "");
                        String a = null;
                        for (int i = 0; i < list.size(); i++) {
                            if (name == "R当前产品号" || name.equals("R当前产品号")) {
                                product.setProductID(value);
                                System.out.printf("R当前产品号:" + product.getProductID() + "\n");
                            } else if (name == "R当前型号" || name.equals("R当前型号")) {
                                product.setModel(value);
                                System.out.printf("R当前型号:" + product.getModel() + "\n");
                            } else if (name == "R当前宽度" || name.equals("R当前宽度")) {
                                product.setWidth(Integer.valueOf(value));
                                System.out.printf("R当前宽度:" + product.getWidth() + "\n");
                            } else if (name == "R当前高" || name.equals("R当前高度")) {
                                product.setHeight(Integer.valueOf(value));
                                System.out.printf("R当前高:" + product.getHeight() + "\n");
                            } else if (name == "R当前镀铜时间" || name.equals("R当前镀铜时间")) {
                                product.setCopperplatingtime(Double.valueOf(Integer.valueOf(value)));
                                System.out.printf("R当前镀铜时间:" + product.getCopperplatingtime() + "\n");
                            } else if (name == "R当前镀铜厚度(正)" || name.equals("R当前镀铜厚度(正)")) {
                                product.setCopperplatingthickness1(Double.valueOf(Integer.valueOf(value)));
                                System.out.printf("R当前镀铜厚度(正):" + product.getCopperplatingthickness1() + "\n");
                            } else if (name == "R当前镀铜厚度(反)" || name.equals("R当前镀铜厚度(反)")) {
                                product.setCopperplatingthickness2(Double.valueOf(Integer.valueOf(value)));
                                System.out.printf("R当前镀铜厚度(反):" + product.getCopperplatingthickness2() + "\n");
                            } else if (name == "R当前循环时间" || name.equals("R当前循环时间")) {
                                product.setCycletime(Double.valueOf(Integer.valueOf(value)));
                                System.out.printf("R当前循环时间:" + product.getCycletime() + "\n");
                            } else if (name == "R张数" || name.equals("R张数")) {
                                product.setNumberofsheets(Integer.valueOf(value));
                            }  else if (name == "R当前板厚" || name.equals("R当前板厚")) {
                                product.setPlatethickness(Double.valueOf(value));
                                System.out.printf("R当前产品号:" + product.getProductID() + "\n");
                            }
                        }
                    }
                }
        );
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //df转换成LocalDate
        //将df转换成date
        Date date = null;
        try {
            date = df.parse(df.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
       *//* product.setTime(DateTimeLiteralExpression.DateTime.valueOf(String.valueOf(date)));*//*
        product.setId(123133);
 product.setTermination(true);
        //ProductServiceImpl productService = new ProductServiceImpl();

        *//*productService.insert1(product);*//*
        //将product保存到数据库
        System.out.println(product);
        productService.insert(product);
    }*/


    public static void test2() {
//定时器，每隔10分钟执行
       // String data = JSON.parseObject(sendGet("http://192.168.150.143/proxyapi/dcc/labels", paraMap)).getString("data");
String lh="HP2556036A0";
    Map<String, String> paraMap = new HashMap<>();
    paraMap.put("lh", lh);
    String data = JSON.parseObject(sendGet("http://localhost:9527/xinye/get?lh="+lh, null).toString()).getString("data");

        XinYe xinYe1 = JSON.parseObject(data, XinYe.class);
        System.out.printf("xinYe:"+xinYe1);
        System.out.printf("data:" + data);
    }

    public static void main(String[] args) {
        test2();
    }




}
