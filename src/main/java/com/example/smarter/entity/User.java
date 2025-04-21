package com.example.smarter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Souvenix
 * @time 2025/4/19
 */
@Data
@AllArgsConstructor
public class User {

    /**
     * 用户 id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码哈希值
     */
    private String password;

    /**
     * 用户名联系电话
     */
    private String phone;

    /**
     * 用户创建时间
     */
    private LocalDateTime createTime;

    /**
     * 用户修改时间
     */
    private LocalDateTime updateTime;

    public User() {}

}