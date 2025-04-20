package com.example.smarter.entity.dto.user;

import com.example.smarter.annotation.ValidTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author Souvenix
 * @time 2025/4/19
 */
@Data
@ValidTime
public class QueryUserDTO {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 查询用户的创建时间范围，开始时间
     */
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}",
            message = "时间格式不正确，格式应为 yyyy-MM-dd HH:mm:ss")
    private String startTime;

    /**
     * 查询用户的创建时间范围，结束时间
     */
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}",
            message = "时间格式不正确，格式应为 yyyy-MM-dd HH:mm:ss")
    private String endTime;
}
