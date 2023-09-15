package fun.luink.blog.common.model;

import fun.luink.blog.common.HttpStatus;
import fun.luink.blog.system.service.I18nService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * 统一返回
 */
@Data
@Schema(accessMode = READ_ONLY)
public class R<T> {

    Integer code;//返回编码
    String message;//返回信息
    T data;//返回数据

    /**
     * 全参构造器
     * @param code
     * @param message
     * @param data
     */
    public R(Integer code, String message, T data) {
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
    public static R success(String message, Object data){
        return new R(HttpStatus.SUCCESS,message,data);
    }

    /**
     * 返回成功消息（重载）
     * @param data 返回对象
     * @return
     */
    public static R success(Object data){
        return R.success("success",data);
    }
    /**
     * 返回成功消息（重载）
     * @param message 返回信息
     * @return
     */
    public static R success(String message){
        return R.success(message,null);
    }
    /**
     * 返回成功消息（重载）
     * @return
     */
    public static R success(){
        return R.success("success",null);
    }


    /**
     * 返回错误消息（基础）
     *
     * @param message 返回内容
     * @param data 数据对象
     * @return
     */
    public static R fail(String message, Object data)
    {
        return new R(HttpStatus.ERROR, message, data);
    }
    /**
     * 返回错误消息（重载）
     * @param code 状态码
     * @param message 返回内容
     * @return
     */
    public static R fail(Integer code, String message)
    {
        return new R(code, message, null);
    }
    /**
     * 返回错误消息（重载）
     * @param message 返回信息
     * @return
     */
    public static R fail(String message){
        return R.fail(message,null);
    }
    /**
     * 返回错误消息（重载）
     * @return
     */
    public static R fail(){
        return R.fail("fail",null);
    }
}
