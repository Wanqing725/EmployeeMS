package org.employeems.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.employeems.common.constant.MessageConstant;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Result", description = "统一返回结果")
public class Result<T> implements Serializable {
    /**
     * 编码 1-成功 0-和其它数字为失败
     */
    @ApiModelProperty(value = "编码")
    private Integer code;

    /**
     * 响应信息
     */
    @ApiModelProperty(value = "响应信息")
    private String msg;

    /**
     * 数据
     */
    @ApiModelProperty(value = "数据")
    private T data;

    /**
     * 成功响应
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }

    /**
     * 成功响应 携带信息
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(String msg, T data) {
        Result<T> result = new Result<T>();
        result.code = 1;
        result.msg = msg;
        result.data = data;
        return result;
    }

    /**
     * 成功响应 携带数据
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 1;
        result.msg = MessageConstant.OPERATE_SUCCESS;
        return result;
    }

    /**
     * 失败响应
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<T>();
        result.msg = msg;
        result.code = 0;
        return result;
    }
}
