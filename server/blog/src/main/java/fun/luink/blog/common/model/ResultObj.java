package fun.luink.blog.common.model;

import fun.luink.blog.common.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * 统一返回
 */
@Data
@Schema(accessMode = READ_ONLY)
public class ResultObj {

    Integer code;//返回编码
    String message;//返回信息
    Object data;//返回数据

    /**
     * 全参构造器
     * @param code
     * @param message
     * @param data
     */
    public ResultObj(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    /**
     * 返回成功消息（基础）
     *
     * @param message 返回内容
     * @param data 数据对象
     * @return 错误消息
     */
    public static ResultObj success(String message,Object data){
        return new ResultObj(HttpStatus.SUCCESS,message,data);
    }

    /**
     * 返回成功消息（重载）
     * @param data 返回对象
     * @return
     */
    public static ResultObj success(Object data){
        return ResultObj.success("请求成功",data);
    }
    /**
     * 返回成功消息（重载）
     * @param message 返回信息
     * @return
     */
    public static ResultObj success(String message){
        return ResultObj.success(message,null);
    }
    /**
     * 返回成功消息（重载）
     * @return
     */
    public static ResultObj success(){
        return ResultObj.success("请求成功",null);
    }


    /**
     * 返回错误消息（基础）
     *
     * @param message 返回内容
     * @param data 数据对象
     * @return
     */
    public static ResultObj error(String message, Object data)
    {
        return new ResultObj(HttpStatus.ERROR, message, data);
    }
    /**
     * 返回错误消息（重载）
     * @param code 状态码
     * @param message 返回内容
     * @return
     */
    public static ResultObj error(Integer code, String message)
    {
        return new ResultObj(code, message, null);
    }
    /**
     * 返回错误消息（重载）
     * @param message 返回信息
     * @return
     */
    public static ResultObj error(String message){
        return ResultObj.error(message,null);
    }
    /**
     * 返回错误消息（重载）
     * @return
     */
    public static ResultObj error(){
        return ResultObj.error("请求失败",null);
    }
}
