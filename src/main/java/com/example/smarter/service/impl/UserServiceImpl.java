package com.example.smarter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.smarter.entity.User;
import com.example.smarter.entity.dto.user.QueryUserDTO;
import com.example.smarter.entity.vo.user.UserVO;
import com.example.smarter.mapper.UserMapper;
import com.example.smarter.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Souvenix
 * @time 2025/4/19
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserVO> queryUserByCondition(QueryUserDTO queryUserDTO) {
        QueryWrapper<User> queryWrapper = Wrappers.query();

        // 根据 QueryUserDTO 构建查询条件
        if (queryUserDTO.getUsername() != null) {
            queryWrapper.eq("username", queryUserDTO.getUsername());
        }
        if (queryUserDTO.getStartTime() != null) {
            queryWrapper.ge("create_time", queryUserDTO.getStartTime());
        }
        if (queryUserDTO.getEndTime() != null) {
            queryWrapper.le("create_time", queryUserDTO.getEndTime());
        }

        // 执行查询
        List<User> userList = userMapper.selectList(queryWrapper);

        // 将 User 转换为 UserVO
        return userList.stream()
                .map(user -> {
                    UserVO userVO = new UserVO();
                    BeanUtils.copyProperties(user, userVO);
                    return userVO;
                })
                .collect(Collectors.toList());
    }
}
