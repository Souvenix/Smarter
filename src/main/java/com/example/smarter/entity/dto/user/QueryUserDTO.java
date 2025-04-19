package com.example.smarter.entity.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Souvenix
 * @time 2025/4/19
 */
@Data
public class QueryUserDTO {
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 查询用户的创建时间范围，开始时间
     */
    @PastOrPresent(message = "开始时间必须是过去或当前的时间")
    private LocalDateTime startTime;

    /**
     * 查询用户的创建时间范围，结束时间
     */
    @PastOrPresent(message = "结束时间必须是过去或当前的时间")
    // TODO  可以自定义校验注解，确保 endTime 晚于 startTime
    private LocalDateTime endTime;
}
