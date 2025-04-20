package com.example.smarter.util.validator;

import com.example.smarter.annotation.ValidTime;
import com.example.smarter.entity.dto.user.QueryUserDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * @author Souvenix
 * @time 2025/4/20
 */
public class QueryUserDTOTimeValidator implements ConstraintValidator<ValidTime, QueryUserDTO> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    public boolean isValid(QueryUserDTO queryUserDTO, ConstraintValidatorContext context) {
        String startTimeStr = queryUserDTO.getStartTime();
        String endTimeStr = queryUserDTO.getEndTime();

        // 检查 startTime 是否为空
        if (StringUtils.isEmpty(startTimeStr)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("开始时间不能为空")
                    .addPropertyNode("startTime")
                    .addConstraintViolation();
            return false;
        }

        // 检查 endTime 是否为空
        if (StringUtils.isEmpty(endTimeStr)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("结束时间不能为空")
                    .addPropertyNode("endTime")
                    .addConstraintViolation();
            return false;
        }

        // 检查 startTime 和 endTime 是否符合格式
        LocalDateTime startTime = parseDateTime(startTimeStr, context, "startTime");
        if (startTime == null) {
            return false;
        }

        LocalDateTime endTime = parseDateTime(endTimeStr, context, "endTime");
        if (endTime == null) {
            return false;
        }

        // 检查 startTime 是否是过去或当前的时间
        if (!startTime.isBefore(LocalDateTime.now().plusSeconds(1)) && !startTime.isEqual(LocalDateTime.now())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("开始时间必须是过去或当前的时间")
                    .addPropertyNode("startTime")
                    .addConstraintViolation();
            return false;
        }

        // 检查 endTime 是否是过去或当前的时间
        if (!endTime.isBefore(LocalDateTime.now().plusSeconds(1)) && !endTime.isEqual(LocalDateTime.now())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("结束时间必须是过去或当前的时间")
                    .addPropertyNode("endTime")
                    .addConstraintViolation();
            return false;
        }

        // 检查 endTime 是否晚于 startTime
        if (!endTime.isAfter(startTime)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("结束时间必须晚于开始时间")
                    .addPropertyNode("endTime")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }

    private LocalDateTime parseDateTime(String dateTimeStr, ConstraintValidatorContext context, String fieldName) {
        try {
            return LocalDateTime.parse(dateTimeStr, formatter);
        } catch (DateTimeParseException e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("时间格式不正确，格式应为 yyyy-MM-dd HH:mm:ss")
                    .addPropertyNode(fieldName)
                    .addConstraintViolation();
            return null;
        }
    }
}
