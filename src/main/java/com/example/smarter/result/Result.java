package com.example.smarter.result;

/**
 * @author Souvenix
 * @time 2025/4/13
 */
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;
    private String message;
    private T data;

    // 无参构造方法
    public Result() {}

    // 带参数的构造方法
    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 静态方法快速创建成功结果
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "Success", data);
    }

    // 静态方法快速创建失败结果
    public static <T> Result<T> failure(int code, String message) {
        return new Result<>(code, message, null);
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

