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
    private Long id;
    private String username;
    private String password;
    private String phone;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public User() {}

}