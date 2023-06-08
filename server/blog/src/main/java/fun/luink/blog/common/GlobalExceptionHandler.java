package fun.luink.blog.common;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import fun.luink.blog.common.model.ResultObj;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常返回，遇到问题再加
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Log log = LogFactory.get();

    @ExceptionHandler(Exception.class)
    public ResultObj handleException(Exception ex) {
        return ResultObj.error(HttpStatus.ERROR,"系统异常，请与管理员联系");
    }

}
