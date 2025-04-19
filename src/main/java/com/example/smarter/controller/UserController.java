package com.example.smarter.controller;

import com.example.smarter.entity.dto.user.QueryUserDTO;
import com.example.smarter.entity.vo.user.UserVO;
import com.example.smarter.result.Result;
import com.example.smarter.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Souvenix
 * @time 2025/4/19
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/queryByCondition")
    public Result<List<UserVO>> queryUserByCondition(@Valid @RequestBody QueryUserDTO queryUserDTO) {
        return Result.success(userService.queryUserByCondition(queryUserDTO));
    }
}
