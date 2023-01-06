package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述
 *
 * @author: dengyilong
 * @date: 2022年09月03日 14:36
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("liuzijing")
public class LiuZiJing {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Float houdu;
    private String beizhu;
    private String riqi;
    private String ditong;
    private String danwei;
}
