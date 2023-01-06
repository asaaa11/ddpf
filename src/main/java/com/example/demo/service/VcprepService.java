package com.example.demo.service;

import demo.domain.Vcprep;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author HBJLPC0230
* @description 针对表【vcprep】的数据库操作Service
* @createDate 2022-10-22 09:10:18
*/
public interface VcprepService extends IService<Vcprep> {
public List<Vcprep> select(String liaohao) ;
}
