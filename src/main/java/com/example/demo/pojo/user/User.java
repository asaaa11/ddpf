package com.example.demo.pojo.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_table")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;//用户id
    private String kind;//用户类型
    private String username;//用户名
    private String password;//密码
    private String realname;//用户姓名
    private String department;//部门
    private String position;//职位
}
