package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 双翼excel导出数据类
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelSY {
   private String PO;
   private String custlsty;
   private String batch;
   private Integer lenth;
   private Integer width;
   private Float hou;
   private String custsty;
   private String cname;
   private String nospec;
   private String bctp;
   private Integer layer;
   private Integer dbs;
   private Integer pbqty;
   private String cpsiz;
}
