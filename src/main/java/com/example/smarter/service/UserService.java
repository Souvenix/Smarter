package com.example.smarter.service;

import com.example.smarter.entity.dto.user.QueryUserDTO;
import com.example.smarter.entity.vo.user.UserVO;

import java.util.List;

/**
 * @author Souvenix
 * @time 2025/4/19
 */
public interface UserService {
    /**
     * 根据条件查询符合条件的用户
     * @param queryUserDTO
     * @return
     */
    List<UserVO> queryUserByCondition(QueryUserDTO queryUserDTO);
}
