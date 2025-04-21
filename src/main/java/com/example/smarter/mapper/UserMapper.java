package com.example.smarter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smarter.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Souvenix
 * @time 2025/4/19
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
