package com.example.config.exception;

import com.example.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author jijianchang
 */
@RestControllerAdvice
@Slf4j
public class zfRestControllerAdvice {
    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        log.info("binder.getFieldDefaultPrefix {}",binder.getFieldDefaultPrefix());
        log.info("binder.getFieldMarkerPrefix {}",binder.getFieldMarkerPrefix());
    }
    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "harry");
    }



    @ExceptionHandler(RRException.class)
    public Result apiExceptionHandler(RRException ex) {
        log.error("ApiException 异常抛出：{}", ex);
        return Result.error(ex.getMsg());
    }
    @ExceptionHandler(UnknownAccountException.class)
    Result handleException(UnknownAccountException e) {
        log.error("账户错误",e);
        return Result.error("账户错误");
    }
    @ExceptionHandler(LockedAccountException.class)
    Result handleException(LockedAccountException e) {
        log.error("账户已锁定",e);
        return Result.error("账户已锁定");
    }
    @ExceptionHandler(IncorrectCredentialsException.class)
    Result handleException(IncorrectCredentialsException e) {
        log.error("密码不正确",e);
        return Result.error("密码不正确");
    }
    @ExceptionHandler(ExcessiveAttemptsException.class)
    Result handleException(ExcessiveAttemptsException e) {
        log.error("用户名或密码错误次数过多",e);
        return Result.error("用户名或密码错误次数过多");
    }
    @ExceptionHandler(AuthenticationException.class)
    Result handleException(AuthenticationException e) {
        log.error("用户名或密码不正确",e);
        return Result.error("用户名或密码不正确");
    }
    @ExceptionHandler(Exception.class)//该注解的使用可以捕捉到响应的异常信息，比如此处的使用可以获取到最大的exception，未进行异常处理，可以通过全局的异常处理告诉前端，代码报错信息。
    Result handleException(Exception e) {
        log.error("后端异常",e);
        return Result.error(e.getMessage());
    }
}
